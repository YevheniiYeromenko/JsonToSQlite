package com.example.jsontosqlite.Data.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.jsontosqlite.Data.Model.Currency;

import java.util.List;

@Dao
public interface CurrencyDao {
    @Query("SELECT * FROM currency")
    List<Currency> getAll();

    @Insert
    void insertList(List<Currency> currencyList);

    @Query("DELETE FROM currency")
    void clearTable();
}
