package com.example.tuappgenda.model;

import com.example.tuappgenda.model.entities.Profile;

public interface ProfileRepository {

    void getProfile(Callback<Profile> callback);

}
