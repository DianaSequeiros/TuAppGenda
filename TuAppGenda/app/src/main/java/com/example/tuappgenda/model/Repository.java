package com.example.tuappgenda.model;

import com.example.tuappgenda.model.entities.Profile;
import com.example.tuappgenda.model.entities.Subject;
import com.example.tuappgenda.model.entities.Teacher;
import com.example.tuappgenda.model.network.INetwork;

import java.util.ArrayList;

/**
 * Class in charge of choosing, depending on the data to be obtained, between cache, local database or internet to collect the information.
 *  In this case, all the information will be provided by the database.
 */

public class Repository implements LoginRepository, SubjectRepository, TeacherRepository, ProfileRepository{

    private INetwork network;
    private static int idSesion;
    private static Profile profile;

    public Repository(INetwork network) {
        this.network = network;
    }

    @Override
    public void loginRepositorio(String user, String pass, Callback<Boolean> callback) {
        Repository.idSesion = -1;
        network.login(user, pass, new Callback<Profile>() {
            @Override
            public void onSuccess(Profile value) {
                if (value.getId() > 0) {
                    Repository.idSesion = value.getId();
                    Repository.profile = value;
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

    @Override
    public void getProfile(Callback<Profile> callback) {
        callback.onSuccess(profile);
    }

    @Override
    public void editProfile(Profile profileToEdit, Callback<Profile> callback) {
        network.editProfile(idSesion, profileToEdit, new Callback<Profile>() {
            @Override
            public void onSuccess(Profile value) {
                Repository.profile = value;
                callback.onSuccess(value);
            }

            @Override
            public void onFailure(ErrorType error) {
                callback.onFailure(error);
            }
        });
    }
}
