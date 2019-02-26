package com.Sydorenko.controller.Form;

import com.Sydorenko.model.Categories;

public class FurnitureForm {
    String title;
    int price;
    Categories categoryId;
    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public int getPrice () {
        return price;
    }

    public void setPrice ( int price ) {
        this.price = price;
    }

    public Categories getCategoryId () {
        return categoryId;
    }

    public void setCategoryId ( Categories categoryId ) {
        this.categoryId = categoryId;
    }
}
