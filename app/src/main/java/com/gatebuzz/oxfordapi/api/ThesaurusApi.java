package com.gatebuzz.oxfordapi.api;

import com.gatebuzz.oxfordapi.model.Thesaurus;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

@SuppressWarnings("unused")
public interface ThesaurusApi {
  /**
   * Retrieve antonyms for a given word.
   *  Retrieve available [antonyms](/glossary?tag&#x3D;#thesaurus&amp;expand) for a given word and language.     &lt;div id&#x3D;\&quot;antonyms\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An Entry identifier. Case-sensitive. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;Thesaurus&gt;
   */
  
  @GET("entries/{source_lang}/{word_id}/antonyms")
  Observable<Thesaurus> entriesSourceLangWordIdAntonymsGet(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Retrieve synonyms for a given word.
   *  Retrieve available [synonyms](/glossary?tag&#x3D;#thesaurus&amp;expand) for a given word and language.     &lt;div id&#x3D;\&quot;synonyms\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An Entry identifier. Case-sensitive. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;Thesaurus&gt;
   */
  
  @GET("entries/{source_lang}/{word_id}/synonyms")
  Observable<Thesaurus> entriesSourceLangWordIdSynonymsGet(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Retrieve synonyms and antonyms for a given word.
   *  Retrieve available [synonyms and antonyms](/glossary?tag&#x3D;#thesaurus&amp;expand) for a given word and language.     &lt;div id&#x3D;\&quot;synonyms_and_antonyms\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An Entry identifier. Case-sensitive. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;Thesaurus&gt;
   */
  
  @GET("entries/{source_lang}/{word_id}/synonyms;antonyms")
  Observable<Thesaurus> entriesSourceLangWordIdSynonymsantonymsGet(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Header("app_id") String appId, @Header("app_key") String appKey
  );

}
