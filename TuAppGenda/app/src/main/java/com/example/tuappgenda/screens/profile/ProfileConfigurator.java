package com.example.tuappgenda.screens.profile;

import com.example.tuappgenda.model.ProfileRepository;
import com.example.tuappgenda.model.Repository;
import com.example.tuappgenda.model.network.INetwork;
import com.example.tuappgenda.model.network.Network;
import com.example.tuappgenda.model.network.NetworkDownloader;

public class ProfileConfigurator {

    public static void configure (ProfileFragment view){
        NetworkDownloader networkDownloader = NetworkDownloader.getInstance(view.getContext());
        INetwork network = new Network(networkDownloader);
        ProfileRepository repository = new Repository(network);
        IProfilePresenter profilePresenter = new ProfilePresenter(view, repository);
        view.setPresenter(profilePresenter);
    }
}
