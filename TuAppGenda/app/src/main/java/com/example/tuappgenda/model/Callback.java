package com.example.tuappgenda.model;

public interface Callback<T> {

    void onSuccess(T value);
    void onFailure(ErrorType error);

}
