package com.example.tuappgenda.screens.subject;

import com.example.tuappgenda.R;
import com.example.tuappgenda.model.Callback;
import com.example.tuappgenda.model.ErrorType;
import com.example.tuappgenda.model.SubjectRepository;
import com.example.tuappgenda.model.entities.Subject;

import java.util.ArrayList;

public class SubjectPresenter implements ISubjectPresenter {

    ISubjectView view;
    SubjectRepository repository;

    public SubjectPresenter(ISubjectView view, SubjectRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getSubjects() {
        view.showILoading();
        repository.getSubjects(new Callback<ArrayList<Subject>>() {
            @Override
            public void onSuccess(ArrayList<Subject> value) {
                view.hideILoading();
                view.showSubjects(value);
            }

            @Override
            public void onFailure(ErrorType error) {
                view.hideILoading();
                view.showAlert(view.getString(R.string.ErrorLogin));
            }
        });
    }
}
