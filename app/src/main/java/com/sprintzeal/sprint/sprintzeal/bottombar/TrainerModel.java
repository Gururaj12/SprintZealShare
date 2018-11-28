package com.sprintzeal.sprint.sprintzeal.bottombar;

public class TrainerModel {
    String TrainerNAme;
    String TrainerId;

    public TrainerModel() {
    }

    public TrainerModel(String trainerNAme, String trainerId) {
        TrainerNAme = trainerNAme;
        TrainerId = trainerId;
    }

    public String getTrainerNAme() {
        return TrainerNAme;
    }

    public void setTrainerNAme(String trainerNAme) {
        TrainerNAme = trainerNAme;
    }

    public String getTrainerId() {
        return TrainerId;
    }

    public void setTrainerId(String trainerId) {
        TrainerId = trainerId;
    }
}
