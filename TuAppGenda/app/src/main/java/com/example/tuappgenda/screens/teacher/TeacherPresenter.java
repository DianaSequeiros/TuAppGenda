package com.example.tuappgenda.screens.teacher;

import com.example.tuappgenda.R;
import com.example.tuappgenda.model.Callback;
import com.example.tuappgenda.model.ErrorType;
import com.example.tuappgenda.model.TeacherRepository;
import com.example.tuappgenda.model.entities.Teacher;

import java.util.ArrayList;

public class TeacherPresenter implements ITeacherPresenter {

    private ITeacherView view;
    private TeacherRepository repository;

    public TeacherPresenter(ITeacherView view, TeacherRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getTeachers() {
        view.showILoading();
        repository.getTeachers(new Callback<ArrayList<Teacher>>() {
            @Override
            public void onSuccess(ArrayList<Teacher> value) {
                view.hideILoading();
                view.showTeachers(value);
            }

            @Override
            public void onFailure(ErrorType error) {
                view.hideILoading();
                view.showAlert(view.getString(R.string.ErrorLogin));
            }
        });

    }

}
