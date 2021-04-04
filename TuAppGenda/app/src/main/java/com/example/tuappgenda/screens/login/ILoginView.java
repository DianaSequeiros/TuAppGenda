package com.example.tuappgenda.screens.login;

import androidx.annotation.StringRes;

public interface ILoginView {

    void userError(String message);
    void passError(String message);
    void showILoading();
    void hideILoading();
    void showAlert(String message);
    String getString(@StringRes int resId);
}
