package com.Sydorenko.controller.Form;
/** The class which describes the form for creating new Category.
 * This form is transferred from a controller to view in empty state
 * before view template rendering and then turns back to controller
 * after user fills it up with the required information.
 * The information retrieved from the form is processed by controller.
 * @author Oleksandr Sydorenko
 */
public class CategoryForm {
    String category;

    public String getCategory () {
        return category;
    }

    public void setCategory ( String category ) {
        this.category = category;
    }
}
