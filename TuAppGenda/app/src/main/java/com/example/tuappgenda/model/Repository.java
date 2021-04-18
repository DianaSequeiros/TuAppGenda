package com.example.tuappgenda.model;

import com.example.tuappgenda.model.entities.Subject;
import com.example.tuappgenda.model.entities.Teacher;
import com.example.tuappgenda.model.network.INetwork;

import java.util.ArrayList;

public class Repository implements LoginRepository, SubjectRepository, TeacherRepository{

    private INetwork network;
    private static int idSesion;

    public Repository(INetwork network) {
        this.network = network;
    }

    @Override
    public void loginRepositorio(String user, String pass, Callback<Boolean> callback) {
        Repository.idSesion = -1;

        network.login(user, pass, new Callback<Integer>() {
            @Override
            public void onSuccess(Integer value) {
                if (value > 0) {
                    Repository.idSesion = value;
                    callback.onSuccess(true);
                } else {
                    callback.onFailure(ErrorType.UNAUTHORIZED);
                }
            }

            @Override
            public void onFailure(ErrorType error) {
                callback.onFailure(error);
            }
        });

    }

    @Override
    public void getSubjects(Callback<ArrayList<Subject>> callback) {
        network.getSubjects(idSesion, callback);
    }

    @Override
    public void getTeachers(Callback<ArrayList<Teacher>> callback) {
        network.getTeachers(idSesion, callback);
    }
}
