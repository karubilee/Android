package com.example.karubi.listviewtest;

/**
 * Created by karubi on 2017/9/20.
 */

public class Fruit {
    private String name;
    private int imageId;

    public Fruit (String name,int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
