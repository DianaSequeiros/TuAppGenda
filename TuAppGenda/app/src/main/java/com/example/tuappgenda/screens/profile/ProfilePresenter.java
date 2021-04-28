package com.example.tuappgenda.screens.profile;

import com.example.tuappgenda.R;
import com.example.tuappgenda.model.Callback;
import com.example.tuappgenda.model.ErrorType;
import com.example.tuappgenda.model.ProfileRepository;
import com.example.tuappgenda.model.entities.Profile;

public class ProfilePresenter implements IProfilePresenter{

    private IProfileView view;
    private ProfileRepository profileRepository;

    public ProfilePresenter(IProfileView view, ProfileRepository profileRepository) {
        this.view = view;
        this.profileRepository = profileRepository;
    }

    @Override
    public void getProfile() {
        profileRepository.getProfile(new Callback<Profile>() {
            @Override
            public void onSuccess(Profile value) {
                view.showProfile(value);
            }

            @Override
            public void onFailure(ErrorType error) {

            }
        });
    }

    @Override
    public void tapButton(Boolean isEditable) {
        if(isEditable){
            view.changeView(!isEditable, R.string.edit_profile);
        }else{
            view.changeView(!isEditable, R.string.save_profile);
        }

    }
}
