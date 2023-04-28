package com.example.appphone.Dao;

import android.database.sqlite.SQLiteDatabase;

public interface DoctorDao {
    void onCreate(SQLiteDatabase db);

    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
}
