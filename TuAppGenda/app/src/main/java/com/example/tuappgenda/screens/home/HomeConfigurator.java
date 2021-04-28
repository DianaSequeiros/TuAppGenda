package com.example.tuappgenda.screens.home;

import com.example.tuappgenda.model.ProfileRepository;
import com.example.tuappgenda.model.Repository;
import com.example.tuappgenda.model.network.INetwork;
import com.example.tuappgenda.model.network.Network;
import com.example.tuappgenda.model.network.NetworkDownloader;

public class HomeConfigurator {

    public static void configure (HomeActivity view){
        NetworkDownloader networkDownloader = NetworkDownloader.getInstance(view);
        INetwork network = new Network(networkDownloader);
        ProfileRepository repository = new Repository(network);
        IHomePresenter homePresenter = new HomePresenter(repository, view);
        view.setPresenter(homePresenter);
    }
}
