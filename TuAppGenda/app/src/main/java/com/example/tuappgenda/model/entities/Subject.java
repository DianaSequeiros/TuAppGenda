package com.example.tuappgenda.model.entities;

public class Subject {

    private String name;
    private String course;
    private String year;
    private String score;

    public Subject(String name, String course, String year, String score) {
        this.name = name;
        this.course = course;
        this.year = year;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
