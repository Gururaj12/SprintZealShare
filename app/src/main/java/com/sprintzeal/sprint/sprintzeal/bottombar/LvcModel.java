package com.sprintzeal.sprint.sprintzeal.bottombar;

public class LvcModel {
    String name;
    String version;
    int id_;
    int image;
    private boolean isSelected;

    public LvcModel(String name, String version, int id_, int image) {
        this.name = name;
        this.version = version;
        this.id_ = id_;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }
    public void setSelected(boolean selection){
        this.isSelected = selection;
    }

    public boolean isSelected(){
        return isSelected;
    }
}
