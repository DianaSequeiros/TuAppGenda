package com.example.tuappgenda.screens.profile;

import androidx.annotation.StringRes;

import com.example.tuappgenda.model.entities.Profile;

public interface IProfileView {

    void showProfile(Profile profile);
    void changeView(Boolean isClickable, @StringRes int resId);
    void showILoading();
    void hideILoading();
    void showAlert(String message);
    String getString(@StringRes int resId);
}
