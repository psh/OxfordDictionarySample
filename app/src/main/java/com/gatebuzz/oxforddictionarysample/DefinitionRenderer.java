package com.gatebuzz.oxforddictionarysample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pedrogomez.renderers.Renderer;

public class DefinitionRenderer extends Renderer<Definition> {
    private TextView category;
    private TextView word;
    private TextView etymology;
    private TextView meaning;

    @Override
    protected void setUpView(View rootView) {
        category = (TextView) rootView.findViewById(R.id.category);
        word = (TextView) rootView.findViewById(R.id.word);
        etymology = (TextView) rootView.findViewById(R.id.etymology);
        meaning = (TextView) rootView.findViewById(R.id.definition);
    }

    @Override
    protected void hookListeners(View rootView) {
    }

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.definiton_row, parent, false);
    }

    @Override
    public void render() {
        Definition definition = getContent();
        setFieldText(category, definition.getCategory());
        setFieldText(word, definition.getWord());
        setFieldText(etymology, definition.getEtymology());
        setFieldText(meaning, definition.getDefiniton());
    }

    private void setFieldText(TextView field, String text) {
        field.setText(text);
        field.setVisibility(text != null ? View.VISIBLE : View.GONE);
    }
}
