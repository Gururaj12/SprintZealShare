package com.sprintzeal.sprint.sprintzeal;

public class UserModel {
    private int id;
    private String email,fullname,number;

    public UserModel(int id, String email, String fullname, String number) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
