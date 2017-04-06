package com.gatebuzz.oxfordapi.api;

import com.gatebuzz.oxfordapi.model.Filters;
import com.gatebuzz.oxfordapi.model.Languages;
import com.gatebuzz.oxfordapi.model.Regions;
import com.gatebuzz.oxfordapi.model.UtilityLabels;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

@SuppressWarnings("unused")
public interface UtilityApi {
  /**
   * Lists available domains in a given monolingual language dataset.
   * Returns a list of the available [domains](/glossary?tag&#x3D;#domains&amp;expand) for a given monolingual language dataset. 
   * @param sourceLanguage IANA language code. Source Language. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;UtilityLabels&gt;
   */
  
  @GET("domains/{source_language}")
  Observable<UtilityLabels> domainsSourceLanguageGet(
          @Path("source_language") String sourceLanguage, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Lists available domains in a given bilingual language dataset.
   * Returns a list of the available [domains](/glossary?tag&#x3D;#domains&amp;expand) for a given bilingual language dataset. 
   * @param sourceLanguage IANA language code. Source Language. (required)
   * @param targetLanguage IANA language code. Target Language. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;UtilityLabels&gt;
   */
  
  @GET("domains/{source_language}/{target_language}")
  Observable<UtilityLabels> domainsSourceLanguageTargetLanguageGet(
          @Path("source_language") String sourceLanguage, @Path("target_language") String targetLanguage, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Lists available filters for specific endpoint.
   * Returns a list of all the valid filters for a given endpoint to construct API calls. 
   * @param endpoint Name of the endpoint. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;Filters&gt;
   */
  
  @GET("filters/{endpoint}")
  Observable<Filters> filtersEndpointGet(
          @Path("endpoint") String endpoint, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Lists available filters.
   * Returns a list of all the valid filters to construct API calls. 
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;Filters&gt;
   */
  
  @GET("filters")
  Observable<Filters> filtersGet(
          @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Lists available grammatical features in a given language dataset.
   * Returns a list of the available [grammatical features](/glossary?tag&#x3D;#grammaticalfeatures&amp;expand) for a given language dataset. 
   * @param sourceLanguage IANA language code (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;UtilityLabels&gt;
   */
  
  @GET("grammaticalFeatures/{source_language}")
  Observable<UtilityLabels> grammaticalFeaturesSourceLanguageGet(
          @Path("source_language") String sourceLanguage, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Lists available monolingual and bilingual language datasets in the API.
   * Returns a list of monolingual and bilingual language datasets available in the API 
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @param sourceLanguage IANA language code. If provided output will be filtered by sourceLanguage. (optional)
   * @param targetLanguage IANA language code. If provided output will be filtered by sourceLanguage. (optional)
   * @return Call&lt;Languages&gt;
   */
  
  @GET("languages")
  Observable<Languages> languagesGet(
          @Header("app_id") String appId, @Header("app_key") String appKey, @Query("sourceLanguage") String sourceLanguage, @Query("targetLanguage") String targetLanguage
  );

  /**
   * Lists available lexical categories in a given language dataset.
   * Returns a list of available [lexical categories](/glossary?tag&#x3D;#lexicalcategory&amp;expand) for a given language dataset. 
   * @param language IANA language code (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;UtilityLabels&gt;
   */
  
  @GET("lexicalcategories/{language}")
  Observable<UtilityLabels> lexicalcategoriesLanguageGet(
          @Path("language") String language, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Lists available regions in a given monolingual language dataset.
   * Returns a list of the available [regions](/glossary?tag&#x3D;#regions&amp;expand) for a given monolingual language dataset. 
   * @param sourceLanguage IANA language code (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;Regions&gt;
   */
  
  @GET("regions/{source_language}")
  Observable<Regions> regionsSourceLanguageGet(
          @Path("source_language") String sourceLanguage, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Lists available registers in a given monolingual language dataset.
   * Returns a list of the available [registers](/glossary?tag&#x3D;#registers&amp;expand) for a given monolingual language dataset. 
   * @param sourceLanguage IANA language code. Source Language. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;UtilityLabels&gt;
   */
  
  @GET("registers/{source_language}")
  Observable<UtilityLabels> registersSourceLanguageGet(
          @Path("source_language") String sourceLanguage, @Header("app_id") String appId, @Header("app_key") String appKey
  );

  /**
   * Lists available registers in a given bilingual language dataset.
   * Returns a list of the available [registers](/glossary?tag&#x3D;#registers&amp;expand) for a given bilingual language dataset. 
   * @param sourceLanguage IANA language code. Source Language. (required)
   * @param targetLanguage IANA language code. Target Language. (required)
   * @param appId App ID Authentication Parameter (required)
   * @param appKey App Key Authentication Parameter (required)
   * @return Call&lt;UtilityLabels&gt;
   */
  
  @GET("registers/{source_language}/{target_language}")
  Observable<UtilityLabels> registersSourceLanguageTargetLanguageGet(
          @Path("source_language") String sourceLanguage, @Path("target_language") String targetLanguage, @Header("app_id") String appId, @Header("app_key") String appKey
  );

}
