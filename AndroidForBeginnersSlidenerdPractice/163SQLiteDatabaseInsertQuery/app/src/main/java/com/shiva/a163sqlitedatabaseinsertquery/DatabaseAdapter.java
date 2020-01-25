package com.shiva.a163sqlitedatabaseinsertquery;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseAdapter {

    DataHelper dataHelper;

    DatabaseAdapter(Context context) {
        dataHelper = new DataHelper(context);
    }

    public long insertData(String name, String password) {
        SQLiteDatabase sqLiteDatabase = dataHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataHelper.UNAME, name);
        contentValues.put(DataHelper.UPASSWORD, password);
        long id = sqLiteDatabase.insert(DataHelper.TABLE_NAME, null, contentValues);
        return id;
    }

    static class DataHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "SHASHI";
        private static final int DATABASE_VERSION = 3;
        private static final String TABLE_NAME = "SHIVA_TABLE";
        private static final String UID = "_id";
        private static final String UNAME = "Name";
        private static final String UPASSWORD = "Password";
        private static final String CREATE = "CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + UNAME + " VARCHAR(255), " + UPASSWORD + " VARCHAR(255))";
        private static final String DELETE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public DataHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Toast.makeText(context, "DataHelper constructor called.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE);
            Toast.makeText(context, "DataHelper onCreate called.", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(DELETE);
            onCreate(sqLiteDatabase);
            Toast.makeText(context, "DataHelper onUpgrade called.", Toast.LENGTH_SHORT).show();
        }
    }
}