package com.example.tuappgenda.screens.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tuappgenda.R;
import com.example.tuappgenda.screens.profile.ProfileFragment;
import com.example.tuappgenda.screens.school.SchoolFragment;
import com.example.tuappgenda.screens.start.StartFragment;
import com.example.tuappgenda.screens.subject.SubjectFragment;
import com.example.tuappgenda.screens.teacher.TeacherFragment;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.idToolBar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.idDrawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.idHome_FrameLayout, new StartFragment())
                .commit();

        NavigationView navigationView = findViewById(R.id.idNavigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.idStart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.idHome_FrameLayout, new StartFragment()).commit();
                        break;
                    case R.id.idProfile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.idHome_FrameLayout, new ProfileFragment()).commit();
                        break;
                    case R.id.idSubject:
                        getSupportFragmentManager().beginTransaction().replace(R.id.idHome_FrameLayout, new SubjectFragment()).commit();
                        break;
                    case R.id.idTeacher:
                        getSupportFragmentManager().beginTransaction().replace(R.id.idHome_FrameLayout, new TeacherFragment()).commit();
                        break;
                    case R.id.idSchool:
                        getSupportFragmentManager().beginTransaction().replace(R.id.idHome_FrameLayout, new SchoolFragment()).commit();
                        break;
                    case R.id.idGitHub:
                        //TODO:
                        break;
                    case R.id.idLogout:
                        //TODO:
                        break;
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

}