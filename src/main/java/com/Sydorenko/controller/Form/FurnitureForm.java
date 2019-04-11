package com.Sydorenko.controller.Form;

import com.Sydorenko.model.Categories;
/** The class which describes the form for creating new Furniture.
 * This form is transferred from a controller to view in empty state
 * before view template rendering and then turns back to controller
 * after user fills it up with the required information.
 * The information retrieved from the form is processed by controller.
 * @author Oleksandr Sydorenko
 */
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
