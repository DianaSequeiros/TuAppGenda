package com.example.tuappgenda.screens.login;

import android.content.Context;
import android.content.Intent;

import com.example.tuappgenda.screens.home.HomeActivity;

/**
 * When a screen needs to navigate to another one, the Router class launch the new screen.
 *
 */

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
