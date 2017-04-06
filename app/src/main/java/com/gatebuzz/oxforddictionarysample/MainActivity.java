package com.gatebuzz.oxforddictionarysample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.gatebuzz.oxfordapi.api.DictionaryEntriesApi;
import com.gatebuzz.oxfordapi.model.Entry;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView search;
    private DictionaryEntriesApi entriesApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        entriesApi = ((SampleApp) getApplication()).apiClient().get(DictionaryEntriesApi.class);

        search = (TextView) findViewById(R.id.search);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.fab).setOnClickListener(v -> performSearch(search.getText().toString()));
    }

    private void performSearch(final String searchTerm) {
        entriesApi.getDictionaryEntries("en", searchTerm, BuildConfig.APP_ID, BuildConfig.APP_KEY)
                .doOnSubscribe(d -> hideKeyboard())
                .flatMap(re -> Observable.fromIterable(re.getResults()))
                .flatMap(he -> Observable.fromIterable(he.getLexicalEntries()))
                .flatMap(le -> Observable.fromIterable(le.getEntries()).map(e -> new CategorizedEntry(searchTerm, le.getLexicalCategory(), e)))
                .flatMap(ce -> Observable.fromIterable(ce.entry.getSenses()).map(s -> new Definition(ce.category, ce.word, ce.entry, s)))
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .map(this::createAdapter)
                .subscribe(this::updateRecyclerView);
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(recyclerView.getWindowToken(), 0);
    }

    @NonNull
    private RVRendererAdapter<Definition> createAdapter(List<Definition> definitions) {
        RendererBuilder<Definition> builder = new RendererBuilder<Definition>()
                .bind(Definition.class, new DefinitionRenderer());
        ListAdapteeCollection<Definition> collection = new ListAdapteeCollection<>(definitions);
        return new RVRendererAdapter<>(builder, collection);
    }

    private void updateRecyclerView(RVRendererAdapter<Definition> adapter) {
        if (recyclerView.getAdapter() != null) {
            recyclerView.swapAdapter(adapter, true);
        } else {
            recyclerView.setAdapter(adapter);
        }
    }

    private static class CategorizedEntry {
        final String word;
        final String category;
        final Entry entry;

        CategorizedEntry(String word, String category, Entry entry) {
            this.word = word;
            this.category = category;
            this.entry = entry;
        }
    }
}
