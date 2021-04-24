package com.example.tuappgenda.screens.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.tuappgenda.AccessActivity;
import com.example.tuappgenda.R;
import com.example.tuappgenda.screens.login.LoginFragment;
import com.example.tuappgenda.screens.profile.ProfileFragment;
import com.example.tuappgenda.screens.school.SchoolFragment;
import com.example.tuappgenda.screens.start.StartFragment;
import com.example.tuappgenda.screens.subject.SubjectFragment;
import com.example.tuappgenda.screens.teacher.TeacherFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ConcurrentModificationException;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.idToolBar);
        setSupportActionBar(toolbar);

        progressBar =  findViewById(R.id.idProgressBarHome);

        drawerLayout = findViewById(R.id.idDrawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.idHome_FrameLayout, new StartFragment())
                .commit();

        changeTitle(R.string.start);

        NavigationView navigationView = findViewById(R.id.idNavigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.idStart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.idHome_FrameLayout, new StartFragment()).commit();
                        changeTitle(R.string.start);
                        break;
                    case R.id.idProfile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.idHome_FrameLayout, new ProfileFragment()).commit();
                        changeTitle(R.string.profile);
                        break;
                    case R.id.idSubject:
                        getSupportFragmentManager().beginTransaction().replace(R.id.idHome_FrameLayout, new SubjectFragment()).commit();
                        changeTitle(R.string.subjects);
                        break;
                    case R.id.idTeacher:
                        getSupportFragmentManager().beginTransaction().replace(R.id.idHome_FrameLayout, new TeacherFragment()).commit();
                        changeTitle(R.string.teachers);
                        break;
                    case R.id.idSchool:
                        getSupportFragmentManager().beginTransaction().replace(R.id.idHome_FrameLayout, new SchoolFragment()).commit();
                        changeTitle(R.string.school);
                        break;
                    case R.id.idGitHub:
                        String url = "https://github.com/DianaSequeiros/TuAppGenda";
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(browserIntent);
                        break;
                    case R.id.idLogout:
                        AlertDialog.Builder builder=new AlertDialog.Builder(HomeActivity.this);
                        builder.setMessage(R.string.logoutAlert);
                        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void showLoading(){
        progressBar.setVisibility(View.VISIBLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public void hideLoading(){
        progressBar.setVisibility(View.GONE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public void changeTitle(int id){
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle(id);
        }
    }

}