package com.example.karubi.litepaltest;

/**
 * Created by karubi on 2017/10/9.
 */

public class Book {
    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;
    private String press;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getAuthor() {
        return author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPress() {
        return press;
    }
}
