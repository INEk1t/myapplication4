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

    public static final String TABLE_NAME = "task";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TEXT = "text";
    public static final String COLUMN_TYPE = "type";

    private SQLiteDatabase database;

    public Database(Context context) {
        DBOpenHelper openHelper = new DBOpenHelper(context);
        this.database = openHelper.getWritableDatabase();
    }

    public void insert(String text, Integer type) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TEXT, text);
        contentValues.put(COLUMN_TYPE, type);
        database.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<Task> selectAll(){
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Task> tasks = new ArrayList<>();
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String text = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXT));
                Integer type = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_TYPE));
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
                    COLUMN_TEXT + " TEXT," + COLUMN_TYPE + " INTEGER" + ")";
            dtbs.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase dtbs, int oldVersion, int newVersion) {
            dtbs.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        }
    }
}
