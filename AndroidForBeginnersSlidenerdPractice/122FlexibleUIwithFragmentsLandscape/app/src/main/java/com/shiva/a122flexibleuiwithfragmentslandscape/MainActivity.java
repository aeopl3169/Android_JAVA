package com.shiva.a122flexibleuiwithfragmentslandscape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendValue(int value) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentB fragmentB= (FragmentB) fragmentManager.findFragmentById(R.id.fragment_b);
        fragmentB.mehotdSetText(value);
    }
}
