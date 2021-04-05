package com.example.tuappgenda.screens.login;

import com.example.tuappgenda.model.LoginRepository;
import com.example.tuappgenda.model.Repository;
import com.example.tuappgenda.model.network.INetwork;
import com.example.tuappgenda.model.network.Network;
import com.example.tuappgenda.model.network.NetworkDownloader;

public class LoginConfigurator {

    public static void configure (LoginFragment view){
        ILoginRouter loginRouter = new LoginRouter(view.getContext());
        NetworkDownloader networkDownloader = NetworkDownloader.getInstance(view.getContext());
        INetwork network = new Network(networkDownloader);
        LoginRepository repository = new Repository(network);
        ILoginPresenter presenter = new LoginPresenter(view, repository, loginRouter);
        view.setPresenter(presenter);
    }
}
