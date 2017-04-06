package com.gatebuzz.oxforddictionarysample;

import android.app.Application;

import com.gatebuzz.oxfordapi.ApiClient;

public class SampleApp extends Application {
    private ApiClient apiClient;

    @Override
    public void onCreate() {
        super.onCreate();

        apiClient = new ApiClient();
    }

    public ApiClient apiClient() {
        return apiClient;
    }
}
