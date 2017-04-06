package com.gatebuzz.oxfordapi.api;

import com.gatebuzz.oxfordapi.model.RetrieveEntry;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

@SuppressWarnings("unused")
public interface TranslationApi {
  /**
   * Find translation for a given word.
   * Returns target language translations for a given word ID and source language.  In the event that a word in the dataset does not have a direct translation, the response will be a [definition](/glossary?tag&#x3D;#entry&amp;expand) in the target language.    &lt;div id&#x3D;\&quot;translation\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An Entry identifier. Case-sensitive. (required)
   * @param targetLang IANA language code (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;RetrieveEntry&gt;
   */
  
  @GET("entries/{source_lang}/{word_id}/translations&#x3D;{target_lang}")
  Observable<RetrieveEntry> entriesSourceLangWordIdTranslationstargetLangGet(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Path("target_lang") String targetLang, @Header("app_id") String appId, @Header("app_key") String appKey
  );

}
