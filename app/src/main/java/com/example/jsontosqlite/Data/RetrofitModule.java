package com.example.jsontosqlite.Data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModule {
    public APIService createRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://bank.gov.ua/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(APIService.class);
    }
}
