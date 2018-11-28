package com.sprintzeal.sprint.sprintzeal;

public class FlashResponeSpModel {
    String guest_id,login_token,cust_id,screen_view,device_token,device_id;

    public FlashResponeSpModel(String guest_id, String login_token, String cust_id, String screen_view, String device_token, String device_id) {
        this.guest_id = guest_id;
        this.login_token = login_token;
        this.cust_id = cust_id;
        this.screen_view = screen_view;
        this.device_token = device_token;
        this.device_id = device_id;
    }

    public String getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(String guest_id) {
        this.guest_id = guest_id;
    }

    public String getLogin_token() {
        return login_token;
    }

    public void setLogin_token(String login_token) {
        this.login_token = login_token;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getScreen_view() {
        return screen_view;
    }

    public void setScreen_view(String screen_view) {
        this.screen_view = screen_view;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }
}
