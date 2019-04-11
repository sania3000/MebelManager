package com.Sydorenko.controller.Form;
/** The class which describes the form for creating new User.
 * This form is transferred from a controller to view in empty state
 * before view template rendering and then turns back to controller
 * after user fills it up with the required information.
 * The information retrieved from the form is processed by controller.
 * @author Oleksandr Sydorenko
 */
public class UserForm {
    String name;
    String email;
    String password;
    String confirmPassword;
    String address;
    String role;

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress ( String address ) {
        this.address = address;
    }

    public String getRole () {
        return role;
    }

    public void setRole ( String role ) {
        this.role = role;
    }

    public String getConfirmPassword () {
        return confirmPassword;
    }

    public void setConfirmPassword ( String confirmPassword ) {
        this.confirmPassword = confirmPassword;
    }
}
