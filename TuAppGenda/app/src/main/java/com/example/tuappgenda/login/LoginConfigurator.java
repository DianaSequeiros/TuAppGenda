package com.example.tuappgenda.login;

public class LoginConfigurator {

    public static void configure (LoginFragment view){
        ILoginPresenter presenter = new LoginPresenter(view);
        view.setPresenter(presenter);
    }
}
