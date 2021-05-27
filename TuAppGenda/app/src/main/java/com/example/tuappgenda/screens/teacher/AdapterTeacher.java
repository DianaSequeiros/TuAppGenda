package com.example.tuappgenda.screens.teacher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.tuappgenda.R;
import com.example.tuappgenda.model.entities.Teacher;

import java.util.ArrayList;

public class AdapterTeacher extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Teacher> teachers;

    public AdapterTeacher(Context context, int layout, ArrayList<Teacher> teachers) {
        this.context = context;
        this.layout = layout;
        this.teachers = teachers;
    }

    @Override
    public int getCount() {
        return teachers.size();
    }

    @Override
    public Object getItem(int position) {
        return this.teachers.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.layout_teacher, null);

        Teacher currentTeacher= teachers.get(position);
        TextView nameTeacher = (TextView) view.findViewById(R.id.idNameTeacher);
        nameTeacher.setText(currentTeacher.getName());
        TextView surnameTeacher = (TextView) view.findViewById(R.id.idSurnameTeacher);
        surnameTeacher.setText(currentTeacher.getSurname());
        TextView courseTeacher = (TextView) view.findViewById(R.id.idCourseTeacher);
        courseTeacher.setText(currentTeacher.getCourse());
        TextView yearTeacher = (TextView) view.findViewById(R.id.idYearTeacher);
        yearTeacher.setText(currentTeacher.getYear());
        TextView emailTeacher = (TextView) view.findViewById(R.id.idEmailTeacher);
        emailTeacher.setText(currentTeacher.getEmail());

        return view;
    }
}
