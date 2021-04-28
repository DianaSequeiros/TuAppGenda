package com.example.tuappgenda.screens.home;

import com.example.tuappgenda.model.Callback;
import com.example.tuappgenda.model.ErrorType;
import com.example.tuappgenda.model.ProfileRepository;
import com.example.tuappgenda.model.entities.Profile;

public class HomePresenter implements IHomePresenter {

    ProfileRepository repository;
    IHomeView view;

    public HomePresenter(ProfileRepository repository, IHomeView view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void getProfile() {
        repository.getProfile(new Callback<Profile>() {
            @Override
            public void onSuccess(Profile value) {
                view.showProfile(value);
            }

            @Override
            public void onFailure(ErrorType error) {

            }
        });
    }
}
