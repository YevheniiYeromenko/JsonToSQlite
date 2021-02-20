package com.example.jsontosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.jsontosqlite.Data.APIService;
import com.example.jsontosqlite.Data.Database.CurrencyDao;
import com.example.jsontosqlite.Data.Model.Currency;
import com.example.jsontosqlite.Data.RetrofitModule;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity2 extends AppCompatActivity {

    private static OkHttpClient client = new OkHttpClient();
    public static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private List<Currency> currencyList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String responseCurr = MainActivity2.run(Config.URL);
                    //Log.wtf("Json", responseCurr);
                    APIService apiService = new RetrofitModule().createRetrofit();
                    Call<List<Currency>> responceData = apiService.loadCurrency();
                    responceData.enqueue(new Callback<List<Currency>>() {
                        @Override
                        public void onResponse(Call<List<Currency>> call, retrofit2.Response<List<Currency>> response) {
                            response.isSuccessful();
                        }

                        @Override
                        public void onFailure(Call<List<Currency>> call, Throwable t) {

                        }
                    });

                    Gson gson = new Gson();
                    Type currencyListType = new TypeToken<List<Currency>>(){}.getType();
                    currencyList = gson.fromJson(responseCurr, currencyListType);
                    //Log.wtf("Log", currencyList.get(0).txt);

                    CurrencyDao currencyDao = App.getDatabase().currencyDao();
                    currencyDao.insertList(currencyList);
                    Log.wtf("DB", currencyDao.getAll().get(2).txt);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}