package com.example.myapplication;

import com.example.myapplication.model.Category;

public class Task extends Category {
    int id;
    String img;
    String title;
    String type;
    String color;

    public Task(int id, String title) {
        super(id, title);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Task(int id, String img, String title, String type, String color) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.type = type;
        this.color = color;
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