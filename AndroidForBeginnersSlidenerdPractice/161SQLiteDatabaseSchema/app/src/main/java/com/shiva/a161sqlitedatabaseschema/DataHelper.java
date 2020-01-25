package com.shiva.a161sqlitedatabaseschema;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import static java.sql.Types.INTEGER;
import static java.sql.Types.VARCHAR;

public class DataHelper extends SQLiteOpenHelper {

//    private static final String DATABASE_NAME = "SHIVA";
//    private static final Integer DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "SHIVA_TABLE";
    private static final String UID = "_id";
    private static final String UNAME = "Name";
    private static final String UADDRESS = "Address";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + UNAME + " VARCHAR(255), " + UADDRESS + " VARCHAR(255))";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    Context context;

    public DataHelper(@Nullable Context context, @Nullable String DBName, @Nullable SQLiteDatabase.CursorFactory factory, int DBVersion) {
        super(context, DBName, null, DBVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Toast.makeText(context, "TABLE CREATED", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
        Toast.makeText(context, "TABLE UPDATED", Toast.LENGTH_SHORT).show();
    }
}