package com.headhunter.client.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static ApiFactory instance;
    private Retrofit retrofit;
    private static final String BASE_URL = "https://api.hh.ru/";

    public ApiFactory() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiFactory getInstance() {
        if (instance == null) {
            instance = new ApiFactory();
        }

        return instance;
    }

    public ApiService getApiService() {
        return retrofit.create(ApiService.class);
    }

}
