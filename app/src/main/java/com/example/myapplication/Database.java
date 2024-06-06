package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database {

    public static final String DATABASE_NAME = "dbs";
    public static final int DATABASE_VERSION = 1;

//    this.id = id;
//    this.img = img;
//    this.title = title;
//    this.type = type;
//    this.color = color;

    public static final String TABLE_NAME = "task";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IMG = "img";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_COLOR = "color";
    public static final String COLUMN_NUMBER = "number";

    private SQLiteDatabase database;

    public Database(Context context) {
        DBOpenHelper openHelper = new DBOpenHelper(context);
        this.database = openHelper.getWritableDatabase();
    }

    public void insert(int id, String img, String title, String type, String color, String number) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, id);
        contentValues.put(COLUMN_IMG, img);
        contentValues.put(COLUMN_TITLE, title);
        contentValues.put(COLUMN_TYPE, type);
        contentValues.put(COLUMN_COLOR, color);
        contentValues.put(COLUMN_NUMBER, number);
        database.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<Task> selectAll(){
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Task> tasks = new ArrayList<>();
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String img = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMG));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
                String type = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TYPE));
                String color = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_COLOR));
                String number = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NUMBER));
                //tasks.add(new Task(id, text, type));
            } while (cursor.moveToNext());
        }
        return tasks;
    }

    static class DBOpenHelper extends SQLiteOpenHelper {
        DBOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase dtbs) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_IMG + " TEXT," + COLUMN_TITLE + " TEXT" +
                    COLUMN_TYPE + "TEXT," + COLUMN_COLOR + "TEXT" + COLUMN_NUMBER + "TEXT" + ")";
            dtbs.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase dtbs, int oldVersion, int newVersion) {
            dtbs.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        }

//        public Cursor getAllData() {
//            SQLiteDatabase db = this.getReadableDatabase();
//            return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
//        }

    }
}
