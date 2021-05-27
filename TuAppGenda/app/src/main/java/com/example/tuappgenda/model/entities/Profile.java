package com.example.tuappgenda.model.entities;

public class Profile {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String course;
    private String year;
    private String dni;

    public Profile(String name, String surname, String email, String course, String year, String dni) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.course = course;
        this.year = year;
        this.dni = dni;
    }

    public Profile(int id, String name, String surname, String email, String course, String year, String dni) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.course = course;
        this.year = year;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
