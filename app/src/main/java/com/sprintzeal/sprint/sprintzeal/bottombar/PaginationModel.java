package com.sprintzeal.sprint.sprintzeal.bottombar;

import java.util.List;

public class PaginationModel {
    String catName;
    String catId;

    List<CourseListData> courseListData;
    List<TrainerData> trainerData;

    public String getCatName() {
        return catName;
    }

    public String getCatId() {
        return catId;
    }

    public List<CourseListData> getCourseListData() {
        return courseListData;
    }

    public List<TrainerData> getTrainerData() {
        return trainerData;
    }
}

class CourseListData{

    String courseId;
    String courseImgUrl;
    String courseName;

    public String getCourseId() {
        return courseId;
    }

    public String getCourseImgUrl() {
        return courseImgUrl;
    }

    public String getCourseName() {
        return courseName;
    }
}

        class TrainerData{

    String trainerId;
    String trainerName;

            public String getTrainerId() {
                return trainerId;
            }

            public String getTrainerName() {
                return trainerName;
            }
        }
