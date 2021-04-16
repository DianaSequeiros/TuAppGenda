package com.example.tuappgenda.screens.subject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tuappgenda.R;
import com.example.tuappgenda.model.entities.Subject;

import java.util.ArrayList;

public class AdapterSubject extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Subject> subjects;

    public AdapterSubject(Context context, int layout, ArrayList<Subject> subjects){
        this.context = context;
        this.layout = layout;
        this.subjects = subjects;
    }


    @Override
    public int getCount() {
        return this.subjects.size();
    }

    @Override
    public Object getItem(int position) {
        return this.subjects.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.layout_subject, null);

        Subject currentSubject = subjects.get(position);

        TextView name = (TextView) view.findViewById(R.id.idNameSubject);
        name.setText(currentSubject.getName());
        TextView course = (TextView) view.findViewById(R.id.idCourseSubject);
        course.setText(currentSubject.getCourse());
        TextView year = (TextView) view.findViewById(R.id.idYearSubject);
        year.setText(currentSubject.getYear());
        TextView score = (TextView) view.findViewById(R.id.idScore);
        score.setText(currentSubject.getScore());

        return view;
    }
}
