package com.example.tuappgenda.model.entities;

public class Teacher {

    private String name;
    private String surname;
    private String email;
    private String course;
    private String year;

    public Teacher(String name, String surname, String email, String course, String year) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.course = course;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
