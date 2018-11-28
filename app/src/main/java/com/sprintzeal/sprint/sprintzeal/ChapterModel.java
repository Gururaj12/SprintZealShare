package com.sprintzeal.sprint.sprintzeal;

import com.sprintzeal.sprint.sprintzeal.VideoModel;

import java.util.List;

public class ChapterModel {
    String chapterId;
    String chapterName;
    String chapterDesc;
    List<String> video;

    public ChapterModel() {
    }

    public ChapterModel(String chapterId, String chapterName, String chapterDesc, List<String> video) {
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.chapterDesc = chapterDesc;
        this.video = video;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public void setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc;
    }

    public List<String> getVideo() {
        return video;
    }

    public void setVideo(List<String> video) {
        this.video = video;
    }
}
