package com.shiva.a126fragmenttransactionaddremovereplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentA fragmentA;
    FragmentB fragmentB;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentManager = getSupportFragmentManager();
    }

    public void addA(View view) {
        if (fragmentA != null && fragmentA.isVisible()) {
            Toast.makeText(this, "Fragment already added.", Toast.LENGTH_LONG).show();
        } else {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.group, fragmentA, "A");
            fragmentTransaction.commit();
        }
    }

    public void removeA(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragmentA);
        fragmentTransaction.commit();
    }

    public void replaceAbyB(View view) {
        if (fragmentB != null && fragmentB.isVisible()) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.group, fragmentA, "B").commit();
        } else {
            Toast.makeText(this, "B is not there to replace with A", Toast.LENGTH_LONG).show();
        }
    }

    public void addB(View view) {
        if (fragmentB != null && fragmentB.isVisible()) {
            Toast.makeText(this, "Fragment B already added.", Toast.LENGTH_LONG).show();
        } else {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.group, fragmentB, "B").commit();
        }
    }

    public void removeB(View view) {
        fragmentTransaction = fragmentManager.beginTransaction().remove(fragmentB);
        fragmentTransaction.commit();
    }

    public void replaceBbyA(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.group, fragmentB, "B").commit();
    }

    public void attach(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.attach(fragmentA).commit();
    }

    public void detach(View view) {
        if (fragmentA != null && fragmentA.isVisible()) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.detach(fragmentA).commit();
        }
    }
}