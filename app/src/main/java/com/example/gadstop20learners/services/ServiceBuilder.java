package com.example.gadstop20learners.services;

import com.example.gadstop20learners.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ServiceBuilder {
    private static final String GADS_BASE_URL =  "https://gadsapi.herokuapp.com";
    private static final String FORM_BASE_URL = "https://docs.google.com/forms/d/e/";

    private static Gson gson(){
        return new GsonBuilder()
                .setLenient()
                .create();
    }

//    ||||||||||||||||||||||||||||||||||||||||||||| GADS BUILDER |||||||||||||||||||||||||||||||||||||||||||

    /**
     * GADS API builder for {@value GADS_BASE_URL} using {@link GsonConverterFactory}
     */
    private static final Retrofit.Builder gadsBuilder = new Retrofit.Builder()
            .baseUrl(GADS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson()));


    private static final Retrofit gadsRetrofit = gadsBuilder.build();

    /**
     * creates service for the GADS API endpoint
     * @param serviceClass {@link APIService}
     * @param <S>
     * @return {@link S}
     */
    public static <S> S buildGadsService(Class<S> serviceClass){
        return gadsRetrofit.create(serviceClass);
    }

    public static <S> S service(Class<S> serviceClass, String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build().create(serviceClass);
    }

//    ||||||||||||||||||||||||||||||||||||||||||||| FORM BUILDER |||||||||||||||||||||||||||||||||||||||||||

    /**
     * Google Form API builder for {@value FORM_BASE_URL} using {@link GsonConverterFactory}
     */

    private static OkHttpClient provideHttpClient(){

        return new OkHttpClient()
                .newBuilder()
                .build();
    }
      private static final Retrofit formBuilder = new Retrofit.Builder()
              .baseUrl(FORM_BASE_URL)
              .client(provideHttpClient())
              .addConverterFactory(GsonConverterFactory.create())
              .build();

        public static <S> S buildFormService(Class<S> serviceClass){
            return formBuilder.create(serviceClass);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FORM_BASE_URL)
                .build();
//        final QuestionsSpreadsheetWebService spreadsheetWebService = retrofit.create(QuestionsSpreadsheetWebService.class);



}
