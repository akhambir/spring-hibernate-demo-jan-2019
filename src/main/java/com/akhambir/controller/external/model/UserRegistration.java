package com.akhambir.controller.external.model;

import com.akhambir.model.User;

public class UserRegistration {

    private String username;
    private String password;
    private String repeatPassword;
    private String firstName;
    private String lastName;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static User of(UserRegistration ur) {
        User result = new User();
        result.setUsername(ur.getUsername());
        result.setPassword(ur.getPassword());
        result.setFirstName(ur.getFirstName());
        result.setLastName(ur.getLastName());
        return result;
    }
}
