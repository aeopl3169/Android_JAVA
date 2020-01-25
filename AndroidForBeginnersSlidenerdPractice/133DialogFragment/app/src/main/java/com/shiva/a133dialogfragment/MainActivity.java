package com.shiva.a133dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialogMehtod(View view) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
        MyDialog myDialog = new MyDialog();
        myDialog.show(getSupportFragmentManager(),"showString");
    }

    @Override
    public void dialogCommunicate(String message) {
        Toast.makeText(this,"Message: "+message,Toast.LENGTH_LONG).show();
    }
}
