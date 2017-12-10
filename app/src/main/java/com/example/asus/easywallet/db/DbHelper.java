package com.example.asus.easywallet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ASUS on 12/10/2017.
 */


public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "money.db";
    private static final int DATABASE_VERSION = 1;

    //ชื่อฟิล
    public static final String TABLE_NAME = "incomeandchage";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "title";
    public static final String COL_DETAIL = "detail";


    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_TITLE + " TEXT,"
            + COL_DETAIL + " TEXT)";



    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
      cv.put(COL_TITLE, "ถูกหวย");
       cv.put(COL_DETAIL, "3000");
      db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
