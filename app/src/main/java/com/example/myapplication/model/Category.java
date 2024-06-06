package com.example.myapplication.model;

import android.content.Context;

public class Category {

    int id;
    String title;

    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Category(Context id, String title) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
