package com.example.myapplication;

import android.content.Context;

import com.example.myapplication.model.Category;

import java.io.Serializable;

public class Task extends Category implements Serializable {
    int id;
    String img;
    String title;
    String type;
    //String color;
    String number;

    public Task(Context id, String title) {
        super(id, title);
    }

    public Task(int id, String img, String title, String type, String color, String number) {
        super(id, title);
        this.id = id;
        this.img = img;
        this.title = title;
        this.type = type;
        //this.color = color;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String text) {
        this.type = type;
    }
}

//    public String getColor() {
//        return color;
//    }

//    public void setColor(String color) {
//        this.color = color;
//    }
//}