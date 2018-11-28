package com.sprintzeal.sprint.sprintzeal.bottombar;

public class CategoryModel {
    String catname;
    String CourseName;
    String courseid;
    String trainerid;
    String trainername;

    public CategoryModel() {
    }

    public CategoryModel(String catname, String courseName, String courseid, String trainerid, String trainername) {
        this.catname = catname;
        CourseName = courseName;
        this.courseid = courseid;
        this.trainerid = trainerid;
        this.trainername = trainername;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getTrainerid() {
        return trainerid;
    }

    public void setTrainerid(String trainerid) {
        this.trainerid = trainerid;
    }

    public String getTrainername() {
        return trainername;
    }

    public void setTrainername(String trainername) {
        this.trainername = trainername;
    }
}
