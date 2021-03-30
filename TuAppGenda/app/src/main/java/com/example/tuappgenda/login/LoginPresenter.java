package com.example.tuappgenda.login;

public class LoginPresenter implements ILoginPresenter {

    ILoginView view;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    public void loginTap(String user, String pass){
        if(!user.isEmpty() && !pass.isEmpty()){
            view.showILoading();
            //TODO: hacer login
        }else if(user.isEmpty()){
            view.userError();

        } else if(pass.isEmpty()){
            view.passError();
        }


    }
}
