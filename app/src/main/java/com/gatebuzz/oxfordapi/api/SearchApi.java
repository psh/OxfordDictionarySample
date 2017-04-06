package com.gatebuzz.oxfordapi.api;

import com.gatebuzz.oxfordapi.model.Wordlist;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

@SuppressWarnings("unused")
public interface SearchApi {
  /**
   * Find results for search query.
   *  Retrieve available results for a search query and language.     &lt;div id&#x3D;\&quot;search\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @param q Search string. (optional, default to eye)
   * @param prefix Set prefix to true if you&#39;d like to get results only starting with search string. (optional, default to false)
   * @param regions Filter words with specific region(s) E.g., regions&#x3D;us. For now gb, us are available for en language. (optional)
   * @param limit Limit the number of results per response. Default and maximum limit is 5000. (optional)
   * @param offset Offset the start number of the result. (optional)
   * @return Call&lt;Wordlist&gt;
   */
  
  @GET("search/{source_lang}")
  Observable<Wordlist> searchSourceLangGet(
          @Path("source_lang") String sourceLang, @Header("app_id") String appId, @Header("app_key") String appKey, @Query("q") String q, @Query("prefix") Boolean prefix, @Query("regions") String regions, @Query("limit") String limit, @Query("offset") String offset
  );

  /**
   * Find translation results for search query.
   *  Find available translation results  for a search query and language.     &lt;div id&#x3D;\&quot;search_translation\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param targetLang IANA language code (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @param q Search string. (optional, default to eye)
   * @param prefix Set prefix to true if you&#39;d like to get results only starting with search string. (optional, default to false)
   * @param regions Filter words with specific region(s) E.g., regions&#x3D;us. For now gb, us are available for en language. (optional)
   * @param limit Limit the number of results per response. Default and maximum limit is 5000. (optional)
   * @param offset Offset the start number of the result. (optional)
   * @return Call&lt;Wordlist&gt;
   */
  
  @GET("search/{source_lang}/translations&#x3D;{target_lang}")
  Observable<Wordlist> searchSourceLangTranslationstargetLangGet(
          @Path("source_lang") String sourceLang, @Path("target_lang") String targetLang, @Header("app_id") String appId, @Header("app_key") String appKey, @Query("q") String q, @Query("prefix") Boolean prefix, @Query("regions") String regions, @Query("limit") String limit, @Query("offset") String offset
  );

}
