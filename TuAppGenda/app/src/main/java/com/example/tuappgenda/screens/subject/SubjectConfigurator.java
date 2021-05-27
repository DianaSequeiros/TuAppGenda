package com.example.tuappgenda.screens.subject;

import com.example.tuappgenda.model.Repository;
import com.example.tuappgenda.model.SubjectRepository;
import com.example.tuappgenda.model.network.INetwork;
import com.example.tuappgenda.model.network.Network;
import com.example.tuappgenda.model.network.NetworkDownloader;

public class SubjectConfigurator {

    public static void configure (SubjectFragment view){
        NetworkDownloader networkDownloader = NetworkDownloader.getInstance(view.getContext());
        INetwork network = new Network(networkDownloader);
        SubjectRepository subjectRepository = new Repository(network);
        ISubjectPresenter subjectPresenter = new SubjectPresenter(view, subjectRepository);
        view.setPresenter(subjectPresenter);
    }
}
