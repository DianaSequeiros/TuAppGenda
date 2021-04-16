package com.example.tuappgenda.screens.subject;

import androidx.annotation.StringRes;

import com.example.tuappgenda.model.entities.Subject;
import java.util.ArrayList;

public interface ISubjectView {

    void showILoading();
    void hideILoading();
    void showSubjects(ArrayList<Subject> subjectList);
    void showAlert(String message);
    String getString(@StringRes int resId);

}
