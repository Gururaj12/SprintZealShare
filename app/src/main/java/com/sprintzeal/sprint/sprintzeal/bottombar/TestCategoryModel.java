package com.sprintzeal.sprint.sprintzeal.bottombar;

import java.util.List;

public class TestCategoryModel  {

    String catId;
    String catName;
    List<ExampleCourseList> exampleCourseLists;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public List<ExampleCourseList> getExampleCourseLists() {
        return exampleCourseLists;
    }

    public void setExampleCourseLists(List<ExampleCourseList> exampleCourseLists) {
        this.exampleCourseLists = exampleCourseLists;
    }
}
