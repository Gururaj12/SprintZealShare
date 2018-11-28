package com.sprintzeal.sprint.sprintzeal;

public class DemoCourseBean {
    String title,chapters,videos,studyGuide,categoryId,courseId;

    public DemoCourseBean(String title, String chapters, String videos, String studyGuide, String categoryId, String courseId) {
        this.title = title;
        this.chapters = chapters;
        this.videos = videos;
        this.studyGuide = studyGuide;
        this.categoryId = categoryId;
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapters() {
        return chapters;
    }

    public void setChapters(String chapters) {
        this.chapters = chapters;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public void setStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}

