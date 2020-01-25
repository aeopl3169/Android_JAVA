package com.shiva.a16buttonimplementingonclicklistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(this);

        Log.i("btn","button: "+button.getId());
        Log.i("btn","button: "+R.id.button1);

        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.w("btn","Id of clicked button is: "+view.getId());
        Log.w("btn","Button clicked.");

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
