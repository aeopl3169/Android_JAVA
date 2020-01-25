package com.shiva.a1241portraitonefragmentlandtwofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentA.Communicator {

    FragmentA fragmentA;
    FragmentB fragmentB;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentA = (FragmentA)fragmentManager.findFragmentById(R.id.fragmentA);
        fragmentA.setCommunicator(this);
    }

    @Override
    public void respond(int data) {
        fragmentB = (FragmentB) fragmentManager.findFragmentById(R.id.fragmentB);
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
