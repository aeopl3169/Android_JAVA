package com.shiva.fragmentlifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("ACTIVITY","onCreate activity called.");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("ACTIVITY","onStart activity called.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("ACTIVITY","onRestart activity called.");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.w("ACTIVITY","onRestoreInstanceState activity called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("ACTIVITY","onResume activity called.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("ACTIVITY","onPause activity called.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("ACTIVITY","onStop activity called.");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.w("ACTIVITY","onSaveInstanceState activity called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("ACTIVITY","onDestroy activity called.");
    }
}