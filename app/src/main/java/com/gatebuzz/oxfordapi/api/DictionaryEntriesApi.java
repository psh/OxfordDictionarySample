package com.gatebuzz.oxfordapi.api;


import com.gatebuzz.oxfordapi.model.RetrieveEntry;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

@SuppressWarnings("unused")
public interface DictionaryEntriesApi {
  /**
   * Retrieve only definitions in entry search.
   *  Find available [dictionary entries](/glossary?tag&#x3D;#entry&amp;expand) for given word and language. Filter results by categories.     &lt;div id&#x3D;\&quot;dictionary_entries_filters_definitions\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An Entry identifier. Case-sensitive. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;RetrieveEntry&gt;
   */
  
  @GET("entries/{source_lang}/{word_id}/definitions")
  Observable<RetrieveEntry> entriesSourceLangWordIdDefinitionsGet(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Retrieve only example sentences in entry search.
   *  Find available [dictionary entries](/glossary?tag&#x3D;#entry&amp;expand) for given word and language. Filter results by categories.     &lt;div id&#x3D;\&quot;dictionary_entries_filters_examples\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An Entry identifier. Case-sensitive. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;RetrieveEntry&gt;
   */
  
  @GET("entries/{source_lang}/{word_id}/examples")
  Observable<RetrieveEntry> entriesSourceLangWordIdExamplesGet(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Apply filters to entry search.
   *  Find available [dictionary entries](/glossary?tag&#x3D;#entry&amp;expand) for given word and language. Filter results by categories.     &lt;div id&#x3D;\&quot;dictionary_entries_filters\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An Entry identifier. Case-sensitive. (required)
   * @param filters Separate filtering conditions using a semicolon. Conditions take values grammaticalFeatures and/or lexicalCategory and are case-sensitive. To list multiple values in single condition divide them with comma. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;RetrieveEntry&gt;
   */
  
  @GET("entries/{source_lang}/{word_id}/{filters}")
  Observable<RetrieveEntry> entriesSourceLangWordIdFiltersGet(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Path("filters") List<String> filters, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Retrieve dictionary entries for a given word.
   *  Retrieve available [dictionary entries](/glossary?tag&#x3D;#entry&amp;expand) for a given word and language.     &lt;div id&#x3D;\&quot;dictionary_entries\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An Entry identifier. Case-sensitive. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;RetrieveEntry&gt;
   */
  
  @GET("entries/{source_lang}/{word_id}")
  Observable<RetrieveEntry> getDictionaryEntries(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Retrieve only pronunciations in entry search.
   *  Find available [dictionary entries](/glossary?tag&#x3D;#entry&amp;expand) for given word and language. Filter results by categories.     &lt;div id&#x3D;\&quot;dictionary_entries_filters_pronunciations\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An Entry identifier. Case-sensitive. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;RetrieveEntry&gt;
   */
  
  @GET("entries/{source_lang}/{word_id}/pronunciations")
  Observable<RetrieveEntry> entriesSourceLangWordIdPronunciationsGet(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Specify GB or US dictionary for English entry search.
   *  Retrieve available [dictionary entries](/glossary?tag&#x3D;#entry&amp;expand) for given word and language.     &lt;div id&#x3D;\&quot;dictionary_entries\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param wordId An Entry identifier. Case-sensitive. (required)
   * @param region Region filter parameter. gb &#x3D; Great Britain English. us &#x3D; United States English. Default is gb. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;RetrieveEntry&gt;
   */
  
  @GET("entries/{source_lang}/{word_id}/regions&#x3D;{region}")
  Observable<RetrieveEntry> entriesSourceLangWordIdRegionsregionGet(
          @Path("source_lang") String sourceLang, @Path("word_id") String wordId, @Path("region") String region, @Header("app_id") String appId, @Header("app_key") String appKey
  );

}
