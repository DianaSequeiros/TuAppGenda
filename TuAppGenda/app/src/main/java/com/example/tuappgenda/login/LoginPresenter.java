package com.example.tuappgenda.login;

import com.example.tuappgenda.R;

public class LoginPresenter implements ILoginPresenter {

    ILoginView view;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    public void loginTap(String user, String pass){
        if(!user.isEmpty() && !pass.isEmpty()){
            view.showILoading();
            //TODO: hacer login
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
