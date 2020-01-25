package com.shiva.a15buttononclickxml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("BUTTON","R.id.button1: "+R.id.button1);
        Log.w("BUTTON","R.id.button2: "+R.id.button2);

    }

    public void clickMehtod(View view) {
        Log.w("BUTTON","Id: "+view.getId());

        if (view.getId() == R.id.button1){
            Log.i("BUTTON","Button one clicked.");
        }
        else if (view.getId() == R.id.button2){
            Log.i("BUTTON","Button two clicked.");
        }
    }
}
