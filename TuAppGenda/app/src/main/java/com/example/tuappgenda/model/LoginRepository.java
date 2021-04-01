package com.example.tuappgenda.model;

public interface LoginRepository {

    void loginRepositorio(String user, String pass, Callback<Boolean> callback);
}
