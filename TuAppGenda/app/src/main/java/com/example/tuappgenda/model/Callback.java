package com.example.tuappgenda.model;

/**
 * This interface notify another Class of an asynchronous action that has been completed with success or error.
 *
 * @param <T>
 */

public interface Callback<T> {

    void onSuccess(T value);
    void onFailure(ErrorType error);

}
