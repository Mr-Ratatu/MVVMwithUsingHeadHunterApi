package com.headhunter.client.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.headhunter.client.R;
import com.headhunter.client.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame, new MainFragment())
                .commit();
    }
}
