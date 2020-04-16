package com.headhunter.client.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.headhunter.client.R;
import com.headhunter.client.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigation);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navigation();
    }

    private void navigation() {
        navigationView.setOnNavigationItemSelectedListener(
                item -> {
                    NavigationUI.setupWithNavController(navigationView, navController);

                    return false;
                });
    }

}
