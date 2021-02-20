package com.example.jsontosqlite.Data;

import com.example.jsontosqlite.Data.Model.Currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("NBUStatService/v1/statdirectory/exchange?json")
    Call<List<Currency>> loadCurrency();
}
