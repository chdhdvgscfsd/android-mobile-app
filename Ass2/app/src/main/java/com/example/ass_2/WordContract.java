package com.example.ass_2;

import android.provider.BaseColumns;

public class WordContract {
    private WordContract(){};

    public static class WordEntitiy
            implements BaseColumns
    {
        public static final String TABLE_NAME = "words";
        public static final String COLUMN_NAME_WORD = "word";

        public static final String SQL_CREATE = "CREATE TABLE "+
                TABLE_NAME + " ( "+
                _ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME_WORD + " TEXT )";

        public static final String SQL_DROP = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
