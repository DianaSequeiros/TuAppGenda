package com.example.tuappgenda.screens.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tuappgenda.R;
import com.example.tuappgenda.model.entities.Profile;

public class ProfileFragment extends Fragment implements IProfileView {

    private IProfilePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProfileConfigurator.configure(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getProfile();
    }

    @Override
    public void showProfile(Profile profile) {
        //TODO: hacer vista



    }

    public void setPresenter(IProfilePresenter presenter) {
        this.presenter = presenter;
    }
}