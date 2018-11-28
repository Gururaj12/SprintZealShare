package com.sprintzeal.sprint.sprintzeal;

import java.util.List;

public class CategoryCourses {
/*


    private List< Category > category ;
    private List <SubCategory > Subcategory ;

    public CategoryCourses() {
    }

    public CategoryCourses(List<Category> category, List<SubCategory> subcategory) {
        this.category = category;
        Subcategory = subcategory;
    }

    public class Category{

        String catId;
        String catName;



        private List <SubCategory > subCategories = null;

        public Category(String catId, String catName, List<SubCategory> subCategories) {
            this.catId = catId;
            this.catName = catName;
            this.subCategories = subCategories;
        }

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

        public List<SubCategory> getSubCategories() {
            return subCategories;
        }

        public void setSubCategories(List<SubCategory> subCategories) {
            this.subCategories = subCategories;
        }
    }
    public class SubCategory{

        String courseId;
        String courseName;

        public SubCategory(String courseId, String courseName) {
            this.courseId = courseId;
            this.courseName = courseName;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }
    }
*/

    /*String catId;
    String catName;
    String courseId;
    String courseName;

    public CategoryCourses() {
    }

    public CategoryCourses(String catId, String catName, String courseId, String courseName) {
        this.catId = catId;
        this.catName = catName;
        this.courseId = courseId;
        this.courseName = courseName;
    }

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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }*/
    public String title;
    public String rating;
    public String year;
    public String name;

    public CategoryCourses() {
    }

    public CategoryCourses(String title, String rating, String year, String name) {
        this.title = title;
        this.rating = rating;
        this.year = year;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
