package com.shiva.a129fragmentmanageraddtobackstack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    FragmentA fragmentA;
    FragmentB fragmentB;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentManager = getSupportFragmentManager();
        textView = (TextView) findViewById(R.id.textView);
        fragmentManager.addOnBackStackChangedListener(this);
    }

    public void addA(View view) {
        if (fragmentA != null && fragmentA.isVisible()) {
            Toast.makeText(this, "Fragment already added.", Toast.LENGTH_LONG).show();
        } else {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.group, fragmentA, "A");
            fragmentTransaction.addToBackStack("addA_BS");
            fragmentTransaction.commit();
        }
    }

    public void removeA(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragmentA);
        fragmentTransaction.addToBackStack("removeA_BS");
        fragmentTransaction.commit();
    }

    public void replaceAbyB(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.group, fragmentA, "B");
        fragmentTransaction.addToBackStack("replaceAbyB_BS");
        fragmentTransaction.commit();
    }

    public void addB(View view) {
        if (fragmentB != null && fragmentB.isVisible()) {
            Toast.makeText(this, "Fragment B already added.", Toast.LENGTH_LONG).show();
        } else {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.group, fragmentB, "B");
            fragmentTransaction.addToBackStack("addB_BS");
            fragmentTransaction.commit();
        }
    }

    public void removeB(View view) {
        fragmentTransaction = fragmentManager.beginTransaction().remove(fragmentB);
        fragmentTransaction.addToBackStack("removeB_BS");
        fragmentTransaction.commit();
    }

    public void replaceBbyA(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.group, fragmentB, "B");
        fragmentTransaction.addToBackStack("replaceBbyA_BS");
        fragmentTransaction.commit();
    }

    public void attachA(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack("attachA_BS");
        fragmentTransaction.attach(fragmentA).commit();
    }

    public void detachA(View view) {
        if (fragmentA != null && fragmentA.isVisible()) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack("detachA_BS");
            fragmentTransaction.detach(fragmentA).commit();
        }
    }

    public void backButton(View view) {
//        fragmentManager.popBackStackImmediate();
        fragmentManager.popBackStack();
    }

    public void popAddB(View view) {
//        fragmentManager.popBackStack("addB_BS",0);
        fragmentManager.popBackStack("addB_BS", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void onBackStackChanged() {
        textView.setText(textView.getText() + "\n");
        textView.setText("The current status of back stack is: ");
        int count = fragmentManager.getBackStackEntryCount();
        for (int i = count - 1; i >= 0; i--) {
            FragmentManager.BackStackEntry backStackEntry = fragmentManager.getBackStackEntryAt(i);
            textView.setText(textView.getText() + " " + backStackEntry.getName() + " \n");
        }
        textView.setText(textView.getText() + "\n");
    }
}