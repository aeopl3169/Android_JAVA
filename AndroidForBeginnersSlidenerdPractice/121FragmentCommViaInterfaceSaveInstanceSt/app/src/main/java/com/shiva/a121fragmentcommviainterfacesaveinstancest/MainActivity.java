package com.shiva.a121fragmentcommviainterfacesaveinstancest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CommunicatorInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void passValue(String da) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentById(R.id.fragmentBottom);
        fragmentB.changeTextMethod(da);
    }
}
