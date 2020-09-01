package com.example.gadstop20learners.model;

public class LearningHours {
    private String learnerName;
    private String learningHours;
    private String learnerCountry;
    private String badgeUrl;

    public LearningHours() {
    }

    public LearningHours(String learnerName, String learningHours, String learnerCountry, String badgeUrl) {
        this.learnerName = learnerName;
        this.learningHours = learningHours;
        this.learnerCountry = learnerCountry;
        this.badgeUrl = badgeUrl;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public void setLearnerName(String learnerName) {
        this.learnerName = learnerName;
    }

    public String getLearningHours() {
        return learningHours;
    }

    public void setLearningHours(String learningHours) {
        this.learningHours = learningHours;
    }

    public String getLearnerCountry() {
        return learnerCountry;
    }

    public void setLearnerCountry(String learnerCountry) {
        this.learnerCountry = learnerCountry;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    @Override
    public String toString() {
        return "LearningHours{" +
                "learnerName='" + learnerName + '\'' +
                ", learningHours='" + learningHours + '\'' +
                ", learnerCountry='" + learnerCountry + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }
}
