package com.shiva.a22explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button) findViewById(R.id.button);
    }
    public void buttonClicked(View view){

//        Intent intent = new Intent(this, ActivityB.class);
//        startActivity(intent);

        Intent intent = new Intent();
        intent.setClass(this,ActivityB.class);
//        intent.setClassName("com.shiva.a22explicitintents","com.shiva.a22explicitintents.ActivityB");
        startActivity(intent);
    }
}