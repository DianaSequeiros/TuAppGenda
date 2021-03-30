package com.example.tuappgenda.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tuappgenda.AccessActivity;
import com.example.tuappgenda.R;

public class LoginFragment extends Fragment implements ILoginView{

    private ILoginPresenter presenter;
    private Button acceder;
    private EditText user;
    private EditText pass;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        LoginConfigurator.configure(this);

        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        acceder = view.findViewById(R.id.idAcceder);
        user = view.findViewById(R.id.idETuser);
        pass = view.findViewById(R.id.idETpass);

        acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginTap(user.getText().toString(), pass.getText().toString());
            }
        });
    }

    @Override
    public void userError() {
        //TODO: hacer textfield error

    }
    @Override
    public void passError() {
        //TODO: hacer textfield error

    }

    @Override
    public void showILoading() {
        ((AccessActivity) getActivity()).showLoading();
    }

    @Override
    public void hideILoading() {
        ((AccessActivity) getActivity()).hideLoading();
    }

    public void setPresenter(ILoginPresenter presenter) {
        this.presenter = presenter;
    }
}