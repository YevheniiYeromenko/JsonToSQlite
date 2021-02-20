package com.example.jsontosqlite.Data.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.jsontosqlite.Config;
import com.example.jsontosqlite.Data.Model.Currency;

@Database(entities = {Currency.class}, version = Config.DB_VERSION)
public abstract class CurrencyDataBase extends RoomDatabase {
    public abstract CurrencyDao currencyDao();
}
