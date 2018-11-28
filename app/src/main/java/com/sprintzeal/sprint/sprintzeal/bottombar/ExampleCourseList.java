package com.sprintzeal.sprint.sprintzeal.bottombar;

import java.util.List;

class ExampleCourseList {

    String courseId;
    String courseImgUrl;
    String courseName;
    List<ExampleTrainer>  exampleTrainers;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseImgUrl() {
        return courseImgUrl;
    }

    public void setCourseImgUrl(String courseImgUrl) {
        this.courseImgUrl = courseImgUrl;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<ExampleTrainer> getExampleTrainers() {
        return exampleTrainers;
    }

    public void setExampleTrainers(List<ExampleTrainer> exampleTrainers) {
        this.exampleTrainers = exampleTrainers;
    }
}
