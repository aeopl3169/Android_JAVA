package com.spoorthi.sowmya.bus;

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

    public long insertRecored(String busNo, String routeNo, String from, String to, String date, String time, String driverNo) {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(helper.BUS_NO, busNo);
        contentValues.put(helper.ROUTE_NO, routeNo);
        contentValues.put(helper.FROM, from);
        contentValues.put(helper.TO, to);
        contentValues.put(helper.DATE, date);
        contentValues.put(helper.TIME, time);
        contentValues.put(helper.DRIVER_NO, driverNo);
        long id = sqLiteDatabase.insert(helper.TABLE_NAME, null, contentValues);
        return id;
    }

    public StringBuffer viewAllRecords() {

        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        String[] columns = {helper.ID, helper.FROM, helper.TO, helper.DATE, helper.TIME};
        Cursor cursor = sqLiteDatabase.query(helper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer stringBuffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int index0 = cursor.getColumnIndex(helper.ID);
            int index1 = cursor.getColumnIndex(helper.FROM);
            int index2 = cursor.getColumnIndex(helper.TO);
            int index3 = cursor.getColumnIndex(helper.DATE);
            int index4 = cursor.getColumnIndex(helper.TIME);
            int id = cursor.getInt(index0);
            String from = cursor.getString(index1);
            String to = cursor.getString(index2);
            String date = cursor.getString(index3);
            String time = cursor.getString(index4);
            stringBuffer.append(id + " From: " + from + " To: " + to + " Date:" + date + " Time: "+time+"\n");
        }
        return stringBuffer;
    }

    static class Helper extends SQLiteOpenHelper {

        private static final String DB_NAME = "BIG_DATA_BASE";
        private static final int DB_VERSION = 1;
        private static final String TABLE_NAME = "BUS_TABLE";
        private static final String ID = "_id";
        private static final String BUS_NO = "Bus_No";
        private static final String ROUTE_NO = "Route_No";
        private static final String FROM = "Fro";
        private static final String TO = "toDes";
        private static final String DATE = "Date";
        private static final String TIME = "Time";
        private static final String DRIVER_NO = "Driver_No";

        private static final String CREATE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + BUS_NO + " VARCHAR(255), " + ROUTE_NO + " VARCHAR(255), " + FROM + " VARCHAR(255)," + TO + " VARCHAR(255)," + DATE + " VARCHAR(255), " + TIME + " VARCHAR(255)," + DRIVER_NO + " VARCHAR(255));";
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