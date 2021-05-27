package com.example.tuappgenda.screens.subject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tuappgenda.R;
import com.example.tuappgenda.model.entities.Subject;
import com.example.tuappgenda.screens.home.HomeActivity;

import java.util.ArrayList;

public class SubjectFragment extends Fragment implements ISubjectView {

    private ISubjectPresenter presenter;
    private ListView listSubject;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SubjectConfigurator.configure(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subject, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getSubjects();
        listSubject = getView().findViewById(R.id.idListSubjects);
    }

    @Override
    public void showILoading() {
        ((HomeActivity) getActivity()).showLoading();
    }

    @Override
    public void hideILoading() {
        ((HomeActivity) getActivity()).hideLoading();
    }

    @Override
    public void showSubjects(ArrayList<Subject> subjectList) {
        AdapterSubject adapterSubject = new AdapterSubject(this.getContext(), R.layout.layout_subject, subjectList);
        listSubject.setAdapter(adapterSubject);
    }

    @Override
    public void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message)
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        builder.create();
        builder.show();
    }

    public void setPresenter(ISubjectPresenter presenter){
        this.presenter = presenter;
    }
}