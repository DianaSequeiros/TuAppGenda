package com.example.tuappgenda.screens.teacher;

import com.example.tuappgenda.model.Repository;
import com.example.tuappgenda.model.TeacherRepository;
import com.example.tuappgenda.model.network.INetwork;
import com.example.tuappgenda.model.network.Network;
import com.example.tuappgenda.model.network.NetworkDownloader;

public class TeacherConfigurator {

    public static void configure (TeacherFragment view){
        NetworkDownloader networkDownloader = NetworkDownloader.getInstance(view.getContext());
        INetwork network = new Network(networkDownloader);
        TeacherRepository repository = new Repository(network);
        ITeacherPresenter teacherPresenter = new TeacherPresenter(view, repository);
        view.setPresenter(teacherPresenter);
    }
}
