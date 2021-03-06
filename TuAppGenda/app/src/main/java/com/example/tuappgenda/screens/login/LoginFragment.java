package com.example.tuappgenda.screens.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tuappgenda.AccessActivity;
import com.example.tuappgenda.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment implements ILoginView{

    private ILoginPresenter presenter;
    private Button acceder;
    private EditText user;
    private EditText pass;
    private TextInputLayout userLayout;
    private TextInputLayout passLayout;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        LoginConfigurator.configure(this);

        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        acceder = view.findViewById(R.id.idButtonLogin);
        user = view.findViewById(R.id.idETuser);
        pass = view.findViewById(R.id.idETpass);
        userLayout = view.findViewById(R.id.id_text_user_input);
        passLayout = view.findViewById(R.id.id_text_pass_input);

        acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginTap(user.getText().toString(), pass.getText().toString());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        user.setText("");
        pass.setText("");
    }

    @Override
    public void userError(String message) {
        userLayout.setError(message);
    }

    @Override
    public void passError(String message) {
        passLayout.setError(message);
    }

    @Override
    public void showILoading() {
        ((AccessActivity) getActivity()).showLoading();
    }

    @Override
    public void hideILoading() {
        ((AccessActivity) getActivity()).hideLoading();
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

    public void setPresenter(ILoginPresenter presenter) {
        this.presenter = presenter;
    }
}