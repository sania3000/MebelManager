package com.Sydorenko.controller.Form;

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
