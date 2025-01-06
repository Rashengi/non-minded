package com.oop.courseprojects.studentproject;

import java.io.Serializable;

public class Course implements Serializable{
    private String courseId, title, type;
    private int noOfCredits;

    public Course() {
    }

    public Course(String courId, String title, String type, int noOfCredits) {
        this.courseId = courId;
        this.title = title;
        this.type = type;
        this.noOfCredits = noOfCredits;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courId) {
        this.courseId = courId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNoOfCredits() {
        return noOfCredits;
    }

    public void setNoOfCredits(int noOfCredits) {
        this.noOfCredits = noOfCredits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courId='" + courseId + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", noOfCredits=" + noOfCredits +
                '}';
    }

    public String toString(String reason) {
        return courseId+","+title+","+type+","+noOfCredits+"\n";
    }

}
