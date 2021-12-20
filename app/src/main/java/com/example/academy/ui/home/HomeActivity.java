package com.example.academy.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.academy.R;
import com.example.academy.SectionsPagerAdapter;
import com.example.academy.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityHomeBinding activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        activityHomeBinding.viewPager.setAdapter(sectionsPagerAdapter);
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager);

        if (getSupportActionBar() !=null){
            getSupportActionBar().setElevation(0);
        }
    }
}