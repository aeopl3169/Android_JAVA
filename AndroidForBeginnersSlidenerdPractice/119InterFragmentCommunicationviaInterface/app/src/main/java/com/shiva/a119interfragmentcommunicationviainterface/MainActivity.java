package com.shiva.a119interfragmentcommunicationviainterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void passValue(String data) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentB fragmentB = (FragmentB)fragmentManager.findFragmentById(R.id.fragmentBottom);
//        FragmentB fragmentB = new FragmentB();
        fragmentB.changeTextMethod(data);
    }

}
