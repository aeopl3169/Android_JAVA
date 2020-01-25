package com.shiva.a165sqlitedatabaseselectgetdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseAdapter {

    Helper helper;

    DatabaseAdapter(Context context) {
        helper = new Helper(context);
    }

    public long insertRow(String name, String pass) {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(helper.NAME, name);
        contentValues.put(helper.PASSWORD, pass);
        long id = sqLiteDatabase.insert(helper.TABLE_NAME, null, contentValues);
        return id;
    }

    public String getAllValues() {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        String[] columns = {helper.ID, helper.NAME, helper.PASSWORD};
        Cursor cursor = sqLiteDatabase.query(helper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String pass = cursor.getString(2);
            stringBuffer.append(id + " " + name + " " + pass + "\n");
        }
        return stringBuffer.toString();
    }

    public String getParticularValues(String name) {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        String[] columns = {helper.NAME, helper.PASSWORD};
        Cursor cursor = sqLiteDatabase.query(helper.TABLE_NAME, columns, helper.NAME + "='" + name + "'", null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int index1 = cursor.getColumnIndex(helper.NAME);
            int index2 = cursor.getColumnIndex(helper.PASSWORD);
            String userName = cursor.getString(index1);
            String pass = cursor.getString(index2);
            stringBuffer.append(name + " " + pass + "\n");
        }
        return stringBuffer.toString();
    }

    static class Helper extends SQLiteOpenHelper {

        private static final String DB_NAME = "PEN";
        private static final int DB_VERSION = 1;
        private static final String TABLE_NAME = "CELLO_TABLE";
        private static final String ID = "_id";
        private static final String NAME = "Name";
        private static final String PASSWORD = "Password";
        private static final String CREATE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), " + PASSWORD + " VARCHAR(255))";
        private static final String DELETE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public Helper(@Nullable Context context) {
            super(context, DB_NAME, null, DB_VERSION);
            this.context = context;
            Toast.makeText(context, "Helper constructor called", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE);
            Toast.makeText(context, "onCreate called", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(DELETE);
            onCreate(sqLiteDatabase);
            Toast.makeText(context, "onUpgrade called", Toast.LENGTH_LONG).show();
        }
    }
}