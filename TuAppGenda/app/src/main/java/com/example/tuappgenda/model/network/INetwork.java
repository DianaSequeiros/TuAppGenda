package com.example.tuappgenda.model.network;

import com.example.tuappgenda.model.Callback;
import com.example.tuappgenda.model.entities.Subject;

import java.util.ArrayList;

public interface INetwork {

    /**
     * Do login with server
     * @param user
     * @param pass
     * @param callback return onSuccess the session id
     * */
    void login(String user, String pass, Callback<Integer> callback);

    void getSubjects(int idSession, Callback<ArrayList<Subject>> callback);
}
