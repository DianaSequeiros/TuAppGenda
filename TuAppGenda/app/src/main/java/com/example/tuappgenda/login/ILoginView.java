package com.example.tuappgenda.login;

import androidx.annotation.StringRes;

public interface ILoginView {

    void userError(String message);
    void passError(String message);
    void showILoading();
    void hideILoading();
    String getString(@StringRes int resId);
}
