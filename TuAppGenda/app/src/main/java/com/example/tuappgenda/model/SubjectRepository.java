package com.example.tuappgenda.model;

import com.example.tuappgenda.model.entities.Subject;
import java.util.ArrayList;

public interface SubjectRepository {

    void getSubjects(Callback<ArrayList<Subject>> callback);

}
