package com.shiva.a182looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        myThread = new MyThread();
        myThread.start();
    }

    public void sendMessage(View view) {
        myThread.handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d("LOOPER", " "+Thread.currentThread().getName());
            }
        });
    }

    class MyThread extends Thread {
        Handler handler;

        public MyThread() {
        }

        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler();
            Looper.loop();
        }
    }
}