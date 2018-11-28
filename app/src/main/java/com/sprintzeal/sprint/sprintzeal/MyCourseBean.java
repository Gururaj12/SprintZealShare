package com.sprintzeal.sprint.sprintzeal;

public class MyCourseBean {

    public String title,subTitle,remainingDays,chapters,studyGuide,videos,progress,categoryId,courseId;

    public MyCourseBean(String title, String subTitle, String remainingDays, String chapters, String studyGuide, String videos, String progress, String categoryId, String courseId) {
        this.title = title;
        this.subTitle = subTitle;
        this.remainingDays = remainingDays;
        this.chapters = chapters;
        this.studyGuide = studyGuide;
        this.videos = videos;
        this.progress = progress;
        this.categoryId = categoryId;
        this.courseId = courseId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(String remainingDays) {
        this.remainingDays = remainingDays;
    }

    public String getChapters() {
        return chapters;
    }

    public void setChapters(String chapters) {
        this.chapters = chapters;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public void setStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
