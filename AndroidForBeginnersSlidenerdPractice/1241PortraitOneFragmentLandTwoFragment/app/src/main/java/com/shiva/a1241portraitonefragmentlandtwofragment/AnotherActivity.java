package com.shiva.a1241portraitonefragmentlandtwofragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AnotherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Intent intent = getIntent();
        int index = intent.getIntExtra("sendValueIntent", 0);

        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragmentB);

        if (fragmentB != null) {
            fragmentB.changeMethod(index);
        }
    }
}