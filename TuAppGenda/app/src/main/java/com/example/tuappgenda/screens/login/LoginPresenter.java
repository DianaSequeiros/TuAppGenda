package com.example.tuappgenda.screens.login;

import com.example.tuappgenda.R;
import com.example.tuappgenda.model.Callback;
import com.example.tuappgenda.model.ErrorType;
import com.example.tuappgenda.model.LoginRepository;

public class LoginPresenter implements ILoginPresenter {

    ILoginView view;
    LoginRepository repository;

    public LoginPresenter(ILoginView view, LoginRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void loginTap(String user, String pass){
        if(!user.isEmpty() && !pass.isEmpty()){
            view.showILoading();
            repository.loginRepositorio(user, pass, new Callback<Boolean>() {
                @Override
                public void onSuccess(Boolean value) {
                    view.hideILoading();
                    if(value){
                        //TODO: pasar a la siguiente vista
                    }else{

                    }
                }

                @Override
                public void onFailure(ErrorType error) {
                    view.hideILoading();

                }
            });
        }else {
            if(user.isEmpty()){
                view.userError(view.getString(R.string.userEmpty));
            } else {
                view.userError("");
            }
            if(pass.isEmpty()){
                view.passError(view.getString(R.string.passEmpty));
            }  else {
                view.passError("");
            }
        }


    }
}
