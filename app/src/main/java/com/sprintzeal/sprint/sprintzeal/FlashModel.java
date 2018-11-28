package com.sprintzeal.sprint.sprintzeal;

public class FlashModel {

    private String device_id,token_id,os_version,operating_system,resolution,screen_details,time_zone,model_type,manufacture_model,ip_address,app_version;

    public FlashModel(String device_id, String token_id, String os_version, String operating_system, String resolution, String screen_details, String time_zone, String model_type, String manufacture_model, String ip_address, String app_version) {
        this.device_id = device_id;
        this.token_id = token_id;
        this.os_version = os_version;
        this.operating_system = operating_system;
        this.resolution = resolution;
        this.screen_details = screen_details;
        this.time_zone = time_zone;
        this.model_type = model_type;
        this.manufacture_model = manufacture_model;
        this.ip_address = ip_address;
        this.app_version = app_version;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getToken_id() {
        return token_id;
    }

    public void setToken_id(String token_id) {
        this.token_id = token_id;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getOperating_system() {
        return operating_system;
    }

    public void setOperating_system(String operating_system) {
        this.operating_system = operating_system;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getScreen_details() {
        return screen_details;
    }

    public void setScreen_details(String screen_details) {
        this.screen_details = screen_details;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getModel_type() {
        return model_type;
    }

    public void setModel_type(String model_type) {
        this.model_type = model_type;
    }

    public String getManufacture_model() {
        return manufacture_model;
    }

    public void setManufacture_model(String manufacture_model) {
        this.manufacture_model = manufacture_model;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }
}
