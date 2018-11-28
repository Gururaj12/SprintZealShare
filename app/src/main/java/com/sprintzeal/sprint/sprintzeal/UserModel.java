package com.sprintzeal.sprint.sprintzeal;

public class UserModel {
    private int id;
    private String email,fullname,number,lastname,ip_address;



    public UserModel(int id, String email, String fullname, String number,String lastname,String ip_address) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.number = number;
        this.lastname=lastname;
        this.ip_address=ip_address;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
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