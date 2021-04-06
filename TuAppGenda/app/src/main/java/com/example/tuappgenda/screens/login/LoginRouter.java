package com.example.tuappgenda.screens.login;

import android.content.Context;
import android.content.Intent;

import com.example.tuappgenda.screens.home.HomeActivity;

public class LoginRouter implements ILoginRouter {
    private Context context;

    public LoginRouter(Context context) {
        this.context = context;
    }

    public void navigateToHome(){
        Intent i = new Intent(context, HomeActivity.class);
        context.startActivity(i);
    }
}
