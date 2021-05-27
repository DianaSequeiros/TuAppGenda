package com.example.tuappgenda.screens.teacher;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tuappgenda.R;
import com.example.tuappgenda.model.entities.Teacher;
import com.example.tuappgenda.screens.home.HomeActivity;

import java.util.ArrayList;

public class TeacherFragment extends Fragment implements ITeacherView{

    private ITeacherPresenter presenter;
    private ListView listTeachers;

    @Override
    public void onResume() {
        super.onResume();
        presenter.getTeachers();
        listTeachers = getView().findViewById(R.id.idListTeachers);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TeacherConfigurator.configure(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher, container, false);
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
    public void showTeachers(ArrayList<Teacher> teacherList) {
        AdapterTeacher adapterTeacher = new AdapterTeacher(this.getContext(), R.layout.layout_teacher, teacherList);
        listTeachers.setAdapter(adapterTeacher);
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

    public void setPresenter(ITeacherPresenter presenter){
        this.presenter = presenter;
    }
}