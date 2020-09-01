package com.example.gadstop20learners.services;

import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    private static final String BASE_URL =  "https://gadsapi.herokuapp.com/";
    private static Retrofit.Builder sBuilder = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit sRetrofit = sBuilder.build();
    public static <S> S builderService(Class<S> serviceType){
        return sRetrofit.create(serviceType);
    }

}
