package com.gatebuzz.oxfordapi.api;

import com.gatebuzz.oxfordapi.model.SentencesResults;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

@SuppressWarnings("unused")
public interface TheSentenceDictionaryApi {
  /**
   * Retrieve corpus sentences for a given word.
   *  Retrieve list of sentences and list of [senses](/glossary?tag&#x3D;#sense&amp;expand) (English language only).   &lt;div id&#x3D;\&quot;sentences\&quot;&gt;&lt;/div&gt; 
   * @param sourceLanguage IANA language code. (required)
   * @param wordId An Entry identifier. Case-sensitive. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;SentencesResults&gt;
   */
  
  @GET("entries/{source_language}/{word_id}/sentences")
  Observable<SentencesResults> entriesSourceLanguageWordIdSentencesGet(
          @Path("source_language") String sourceLanguage, @Path("word_id") String wordId, @Header("app_id") String appId, @Header("app_key") String appKey
  );

}
