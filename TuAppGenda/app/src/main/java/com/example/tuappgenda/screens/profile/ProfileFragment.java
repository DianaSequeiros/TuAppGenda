package com.example.tuappgenda.screens.profile;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tuappgenda.R;
import com.example.tuappgenda.model.Callback;
import com.example.tuappgenda.model.entities.Profile;

public class ProfileFragment extends Fragment implements IProfileView {

    private IProfilePresenter presenter;
    private Button buttonProfile;
    private EditText nameProfile;
    private EditText surnameProfile;
    private EditText emailProfile;
    private EditText courseProfile;
    private EditText yearProfile;
    private EditText dniProfile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProfileConfigurator.configure(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonProfile = view.findViewById(R.id.idButtonProfile);
        nameProfile = view.findViewById(R.id.idNameProfile);
        surnameProfile = view.findViewById(R.id.idSurnameProfile);
        emailProfile = view.findViewById(R.id.idEmailProfile);
        courseProfile = view.findViewById(R.id.idCourseProfile);
        yearProfile = view.findViewById(R.id.idYearProfile);
        dniProfile = view.findViewById(R.id.idDniProfile);
        changeView(false, R.string.edit_profile);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.tapButton(nameProfile.isEnabled());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getProfile();
    }

    @Override
    public void showProfile(Profile profile) {
        nameProfile.setText(profile.getName());
        surnameProfile.setText(profile.getSurname());
        emailProfile.setText(profile.getEmail());
        courseProfile.setText(profile.getCourse());
        yearProfile.setText(profile.getYear());
        dniProfile.setText(profile.getDni());
    }

    @Override
    public void changeView(Boolean mustClickable, int resId) {
        changeEditText(nameProfile, mustClickable);
        changeEditText(surnameProfile, mustClickable);
        changeEditText(emailProfile, mustClickable);
        changeEditText(courseProfile, mustClickable);
        changeEditText(yearProfile, mustClickable);
        changeEditText(dniProfile, mustClickable);
        buttonProfile.setText(resId);
    }


    public void setPresenter(IProfilePresenter presenter) {
        this.presenter = presenter;
    }

    private void changeEditText(EditText editText, Boolean isEnable){
        editText.setFocusable(isEnable);
        editText.setFocusableInTouchMode(isEnable);
        editText.setEnabled(isEnable);
        editText.setClickable(isEnable);

        if(isEnable){
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
            editText.setBackgroundColor(getResources().getColor(R.color.black_transparent));
        }else{
            editText.setInputType(InputType.TYPE_NULL);
            editText.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}