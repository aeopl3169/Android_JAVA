package com.shiva.a124portraitonefragmentlandtwofragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(int data) {
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragmentB);
        if (fragmentB != null && fragmentB.isVisible()) {
            // Landscape
            fragmentB.changeMethod(data);
        } else {
            // Portrait
            Intent intent = new Intent(this, AnotherActivity.class);
            intent.putExtra("sendValueIntent",data);
            startActivity(intent);
        }
    }
}
