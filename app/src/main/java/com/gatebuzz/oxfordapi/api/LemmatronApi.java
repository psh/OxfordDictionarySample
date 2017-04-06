package com.gatebuzz.oxfordapi.api;

import com.gatebuzz.oxfordapi.model.Lemmatron;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

@SuppressWarnings("unused")
public interface LemmatronApi {
  /**
   * Apply filters to Lemmatron response
   *  Retrieve available [lemmas](/glossary?tag&#x3D;#lemma&amp;expand) for a given [inflected](/glossary?tag&#x3D;#inflection&amp;expand) wordform. Filter results by categories.      &lt;div id&#x3D;\&quot;lemmatron_filters\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An inflected wordform. Case-sensitive. (required)
   * @param filters Separate filtering conditions using a semicolon. Conditions take values grammaticalFeatures and/or lexicalCategory and are case-sensitive. To list multiple values in single condition divide them with comma. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;Lemmatron&gt;
   */
  
  @GET("inflections/{source_lang}/{word_id}/{filters}")
  Observable<Lemmatron> inflectionsSourceLangWordIdFiltersGet(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Path("filters") List<String> filters, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Retrieve lemmas for a given inflected wordform.
   *  Retrieve available [lemmas](/glossary?tag&#x3D;#lemma&amp;expand) for a given [inflected](/glossary?tag&#x3D;#inflection&amp;expand) wordform.     &lt;div id&#x3D;\&quot;lemmatron\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An inflected wordform. Case-sensitive. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;Lemmatron&gt;
   */
  
  @GET("inflections/{source_lang}/{word_id}")
  Observable<Lemmatron> inflectionsSourceLangWordIdGet(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Header("app_id") String appId, @Header("app_key") String appKey
  );

}
