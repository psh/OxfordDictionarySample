# Oxford Dictionary Sample

## Tools Used
* Android Studio
* Swagger Codegen

## Libraries Used
* Retrofit (http://square.github.io/retrofit/)
* RxJava (https://github.com/ReactiveX/RxJava)
* Renderers (https://github.com/pedrovgs/Renderers)

## Useful Reading
This sample makes use of code generated off the Oxford Dictionary API Swagger documentation (https://developer.oxforddictionaries.com/documentation) - take a look at https://github.com/psh/oxford-dictionary-api-code-gen

## API Calls
Retrofit REST calls to the Oxford Dictionary API look like you are making a simple method call
```java
entriesApi.getDictionaryEntries("en", searchTerm, BuildConfig.APP_ID, BuildConfig.APP_KEY);
```

RxJava makes it a breeze to process the highly nested data structure that is returned from the service call
```java
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
```

![Screenshot](screenshot.png)
