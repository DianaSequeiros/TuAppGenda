package com.example.tuappgenda.screens.teacher;

import androidx.annotation.StringRes;

import com.example.tuappgenda.model.entities.Teacher;

import java.util.ArrayList;

public interface ITeacherView {

    void showILoading();
    void hideILoading();
    void showTeachers(ArrayList<Teacher> teacherList);
    void showAlert(String message);
    String getString(@StringRes int resId);
}
