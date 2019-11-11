package com.example.ass_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class WordDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "words.db";

    public WordDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WordContract.WordEntitiy.SQL_CREATE);
        Log.d("DATABASE", "Database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(WordContract.WordEntitiy.SQL_DROP);
        Log.d("DATABASE", "Database dropped");
        onCreate(db);
    }

    public long insert(SQLiteDatabase db, String word){

        ContentValues values = new ContentValues();
        values.put(WordContract.WordEntitiy.COLUMN_NAME_WORD, word);

        return db.insert(WordContract.WordEntitiy.TABLE_NAME, null, values);
    }

    public Cursor getAllWords(SQLiteDatabase db){
        String[] projection = {
                WordContract.WordEntitiy._ID,
                WordContract.WordEntitiy.COLUMN_NAME_WORD
        };


        return db.query(WordContract.WordEntitiy.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
    }
}
