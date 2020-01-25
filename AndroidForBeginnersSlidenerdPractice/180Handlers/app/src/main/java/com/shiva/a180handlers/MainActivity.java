package com.shiva.a180handlers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Thread thread;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        thread = new Thread(new MyThread());
        thread.start();
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                progressBar.setProgress(msg.arg1);
                Log.d("HANDLER","msg: "+msg);
                Log.d("HANDLER","msg: "+msg.arg1);
            }
        };
    }
    class MyThread implements Runnable{

        @Override
        public void run() {
            for (int i=0; i<100; i++) {
                Message message = Message.obtain();
                message.arg1 = i;
                Log.w("HANDLER","message: "+message);
                Log.i("HANDLER","message.arg1: "+message.arg1);

                // This sendMessage will send message to handleMessage method.
                handler.sendMessage(message);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}