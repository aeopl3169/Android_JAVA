package com.shiva.a168sqlitedatabaseupdatedelete;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseAdapter {

    Helper helper;

    DataBaseAdapter(Context context) {
        helper = new Helper(context);
        Toast.makeText(context, "DataBaseAdapter constructor called", Toast.LENGTH_LONG).show();
    }

    public long insertRecored(String name, String address) {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(helper.NAME, name);
        contentValues.put(helper.ADDRESS, address);
        long id = sqLiteDatabase.insert(helper.TABLE_NAME, null, contentValues);
        return id;
    }

    public StringBuffer viewAllRecords() {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        String[] columns = {helper.ID, helper.NAME, helper.ADDRESS};
        Cursor cursor = sqLiteDatabase.query(helper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int index0 = cursor.getColumnIndex(helper.ID);
            int index1 = cursor.getColumnIndex(helper.NAME);
            int index2 = cursor.getColumnIndex(helper.ADDRESS);
            int id = cursor.getInt(index0);
            String name = cursor.getString(index1);
            String address = cursor.getString(index2);
            stringBuffer.append(id + " " + name + " " + address + " \n");
        }
        return stringBuffer;
    }

    public int updateRecord(String oldName, String newName) {
        // UPDATE "table_name" SET NAME = 'shiva' where NAME=? jon
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(helper.NAME, newName);
        String[] whereArgs = {oldName};
        int count = sqLiteDatabase.update(helper.TABLE_NAME, contentValues, helper.NAME + " =?", whereArgs);
        return count;
    }

    public int deleteRecore(String delete) {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        String[] whereArgs = {delete};
        int deleteRow = sqLiteDatabase.delete(helper.TABLE_NAME, helper.ID + " =?", whereArgs);
        return deleteRow;
    }

    static class Helper extends SQLiteOpenHelper {

        private static final String DB_NAME = "BIG_DATA";
        private static final int DB_VERSION = 1;
        private static final String TABLE_NAME = "INFO_TABLE";
        private static final String ID = "_id";
        private static final String NAME = "Name";
        private static final String ADDRESS = "Address";
        private static final String CREATE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), " + ADDRESS + " VARCHAR(255));";
        private Context context;

        public Helper(@Nullable Context context) {
            super(context, DB_NAME, null, DB_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE);
            Toast.makeText(context, "onCreate called", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            Toast.makeText(context, "onUpgrade called", Toast.LENGTH_LONG).show();
        }
    }
}