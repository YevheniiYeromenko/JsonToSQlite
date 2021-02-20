package com.example.jsontosqlite.Data.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Currency {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public int r030;
    public String txt;
    public double rate;
    public String cc;
    public String exchangedate;
}
