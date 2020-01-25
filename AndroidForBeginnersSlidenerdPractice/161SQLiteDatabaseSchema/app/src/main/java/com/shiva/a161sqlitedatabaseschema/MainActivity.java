package com.shiva.a161sqlitedatabaseschema;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;

public class MainActivity extends AppCompatActivity {

    DataHelper dataHelper;
    private static final String DATABASE_NAME = "SHIVA";
    private static final Integer DATABASE_VERSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataHelper = new DataHelper(this, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase sqLiteDatabase = dataHelper.getWritableDatabase();
    }
}
