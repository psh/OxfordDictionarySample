package com.gatebuzz.oxfordapi.api;

import com.gatebuzz.oxfordapi.model.Wordlist;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

@SuppressWarnings("unused")
public interface WordlistApi {
  /**
   * Retrieve list of words for category with advanced options.
   * Advanced options for retrieving [wordlist](/glossary?tag&#x3D;#wordlist&amp;expand) - exclude filter, filter by word length or match by substring (prefix).     &lt;div id&#x3D;\&quot;wordlist_advanced\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param filtersAdvanced Semicolon separated list of wordlist parameters, presented as value pairs: LexicalCategory, domains, regions, registers. Parameters can take comma separated list of values. E.g., lexicalCategory&#x3D;noun,adjective;domains&#x3D;sport. Number of values limited to 5. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @param exclude Semicolon separated list of parameters-value pairs (same as filters). Excludes headwords that have any senses in specified exclusion attributes (lexical categories, domains, etc.) from results. (optional)
   * @param excludeSenses Semicolon separated list of parameters-value pairs (same as filters). Excludes those senses of a particular headword that match specified exclusion attributes (lexical categories, domains, etc.) from results but includes the headword if it has other permitted senses. (optional)
   * @param excludePrimeSenses Semicolon separated list of parameters-value pairs (same as filters). Excludes a headword only if the primary sense matches the specified exclusion attributes (registers, domains only). (optional)
   * @param wordLength Parameter to speficy the minimum (&gt;), exact or maximum (&lt;) length of the words required. E.g., &gt;5 - more than 5 chars; &lt;4 - less than 4 chars; &gt;5&lt;10 - from 5 to 10 chars; 3 - exactly 3 chars. (optional, default to >5,<10)
   * @param prefix Filter words that start with prefix parameter (optional, default to goal)
   * @param exact If exact&#x3D;true wordlist returns a list of entries that exactly matches the search string. Otherwise wordlist lists entries that start with prefix string. (optional, default to false)
   * @param limit Limit the number of results per response. Default and maximum limit is 5000. (optional)
   * @param offset Offset the start number of the result. (optional)
   * @return Call&lt;Wordlist&gt;
   */
  
  @GET("wordlist/{source_lang}/{filters_advanced}")
  Observable<Wordlist> wordlistSourceLangFiltersAdvancedGet(
          @Path("source_lang") String sourceLang, @Path("filters_advanced") String filtersAdvanced, @Header("app_id") String appId, @Header("app_key") String appKey, @Query("exclude") String exclude, @Query("exclude_senses") String excludeSenses, @Query("exclude_prime_senses") String excludePrimeSenses, @Query("word_length") String wordLength, @Query("prefix") String prefix, @Query("exact") Boolean exact, @Query("limit") String limit, @Query("offset") String offset
  );

  /**
   * Retrieve list of words for category.
   * Retrieve list of words for particular [domain](/glossary?tag&#x3D;#domain&amp;expand), [lexical category](/glossary?tag&#x3D;#lexicalcategory&amp;expand), [register](/glossary?tag&#x3D;#register&amp;expand) and/or [region](/glossary?tag&#x3D;#region&amp;expand).      &lt;div id&#x3D;\&quot;wordlist\&quot;&gt;&lt;/div&gt; 
   * @param sourceLang IANA language code (required)
   * @param filtersBasic Semicolon separated list of wordlist parameters, presented as value pairs: LexicalCategory, domains, regions, registers. Parameters can take comma separated list of values. E.g., lexicalCategory&#x3D;noun,adjective;domains&#x3D;sport. Number of values limited to 5. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @param limit Limit the number of results per response. Default and maximum limit is 5000. (optional)
   * @param offset Offset the start number of the result. (optional)
   * @return Call&lt;Wordlist&gt;
   */
  
  @GET("wordlist/{source_lang}/{filters_basic}")
  Observable<Wordlist> wordlistSourceLangFiltersBasicGet(
          @Path("source_lang") String sourceLang, @Path("filters_basic") String filtersBasic, @Header("app_id") String appId, @Header("app_key") String appKey, @Query("limit") String limit, @Query("offset") String offset
  );

}
