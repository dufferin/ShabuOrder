package com.example.shabuorder.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by Dell on 1/12/2560.
 */

public class FoodDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "foods.db";
    private static final int DATABASE_VERSION = 8;

    public static final String TABLE_NAME = "menu";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "food";
    public static final String COL_PRICE = "price";
    public static final String COL_AMOUNT = "amount";
    public static final String COL_IMAGE = "image";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_IMAGE + " TEXT, "
            + COL_TITLE + " TEXT, "
            + COL_PRICE + " TEXT, "
            + COL_AMOUNT + " TEXT)";

    public FoodDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_IMAGE,"big_pork.jpg");
        cv.put(COL_TITLE, "Pork Set");
        cv.put(COL_PRICE, "199");
        cv.put(COL_AMOUNT, "50");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_IMAGE,"big_meat.jpg");
        cv.put(COL_TITLE, "Meat Set");
        cv.put(COL_PRICE, "219");
        cv.put(COL_AMOUNT, "40");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_IMAGE,"meat_pork.jpg");
        cv.put(COL_TITLE, "Meat+Pork Set");
        cv.put(COL_PRICE, "259");
        cv.put(COL_AMOUNT, "30");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_IMAGE,"big_vegetable.jpg");
        cv.put(COL_TITLE, "Vegeatable Set");
        cv.put(COL_PRICE, "89");
        cv.put(COL_AMOUNT, "50");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_IMAGE,"cheese.jpg");
        cv.put(COL_TITLE, "Cheese");
        cv.put(COL_PRICE, "39");
        cv.put(COL_AMOUNT, "15");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_IMAGE,"ice.jpg");
        cv.put(COL_TITLE, "Ice Bucket");
        cv.put(COL_PRICE, "20");
        cv.put(COL_AMOUNT, "50");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_IMAGE,"pepsi.jpg");
        cv.put(COL_TITLE, "Pepsi");
        cv.put(COL_PRICE, "30");
        cv.put(COL_AMOUNT, "50");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_IMAGE,"water.jpg");
        cv.put(COL_TITLE, "Water");
        cv.put(COL_PRICE, "15");
        cv.put(COL_AMOUNT, "50");
        db.insert(TABLE_NAME, null, cv);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
