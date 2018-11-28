package com.sprintzeal.sprint.sprintzeal.bottombar;

public class MyListModel {
    String mycatname;
    String my_CourseName;
    String my_CourseId;
    String my_trainerid;
    String my_trainername;

    public MyListModel() {
    }

    public MyListModel(String mycatname, String my_CourseName, String my_CourseId, String my_trainerid, String my_trainername) {
        this.mycatname = mycatname;
        this.my_CourseName = my_CourseName;
        this.my_CourseId = my_CourseId;
        this.my_trainerid = my_trainerid;
        this.my_trainername = my_trainername;
    }

    public String getMycatname() {
        return mycatname;
    }

    public void setMycatname(String mycatname) {
        this.mycatname = mycatname;
    }

    public String getMy_CourseName() {
        return my_CourseName;
    }

    public void setMy_CourseName(String my_CourseName) {
        this.my_CourseName = my_CourseName;
    }

    public String getMy_CourseId() {
        return my_CourseId;
    }

    public void setMy_CourseId(String my_CourseId) {
        this.my_CourseId = my_CourseId;
    }

    public String getMy_trainerid() {
        return my_trainerid;
    }

    public void setMy_trainerid(String my_trainerid) {
        this.my_trainerid = my_trainerid;
    }

    public String getMy_trainername() {
        return my_trainername;
    }

    public void setMy_trainername(String my_trainername) {
        this.my_trainername = my_trainername;
    }
}
