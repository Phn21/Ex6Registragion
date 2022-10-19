package com.example.ex6registragion;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    public DBHelper(@Nullable Context context) {
        super(context, "Database6.db", null, 1);
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table users (Number text, Password text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveDT(ContentValues cv) {
        sqLiteDatabase.insert("users", null,cv);
    }

    public String retv(String toString) {
        Cursor c;

        c = sqLiteDatabase.query("users", null, "Number=?", new String[]{toString}, null,null,null);

        c.moveToFirst();

        if (c.getCount()<1){
            return "Not Exist";
        }

        @SuppressLint("Range") String password = c.getString(c.getColumnIndex("Password"));
        return password;
    }
}
