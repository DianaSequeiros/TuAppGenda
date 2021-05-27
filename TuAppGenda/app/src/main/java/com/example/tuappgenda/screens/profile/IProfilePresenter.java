package com.example.tuappgenda.screens.profile;

import com.example.tuappgenda.model.entities.Profile;

public interface IProfilePresenter {

    void getProfile();
    void tapButton(Boolean isEditable, Profile profile);
}
