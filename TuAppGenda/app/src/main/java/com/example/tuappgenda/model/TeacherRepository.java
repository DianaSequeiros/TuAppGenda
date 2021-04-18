package com.example.tuappgenda.model;

import com.example.tuappgenda.model.entities.Teacher;

import java.util.ArrayList;

public interface TeacherRepository {

    void getTeachers(Callback<ArrayList<Teacher>> callback);
}
