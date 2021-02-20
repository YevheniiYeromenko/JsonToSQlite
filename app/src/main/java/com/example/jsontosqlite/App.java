package com.example.jsontosqlite;

import android.app.Application;

import androidx.room.Room;

import com.example.jsontosqlite.Data.Database.CurrencyDataBase;

public class App extends Application {
    public static App instance;

    private CurrencyDataBase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, CurrencyDataBase.class, "database")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public static CurrencyDataBase getDatabase() {
        return instance.database;
    }
}
