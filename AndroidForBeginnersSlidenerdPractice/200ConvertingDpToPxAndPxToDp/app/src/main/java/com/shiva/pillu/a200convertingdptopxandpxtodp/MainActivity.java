package com.shiva.pillu.a200convertingdptopxandpxtodp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Resources resources = getApplicationContext ().getResources ();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics ();
        Log.d ("DP","DisplayMetrics : "+displayMetrics);

        float floatNum =  displayMetrics.xdpi;
        Log.d ("DP","XDPI : "+floatNum);
    }
}
