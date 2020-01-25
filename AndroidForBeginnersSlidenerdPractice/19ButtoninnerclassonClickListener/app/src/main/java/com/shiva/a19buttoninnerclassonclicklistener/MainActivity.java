package com.shiva.a19buttoninnerclassonclicklistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClickHandlerClass clickHandlerClass = new ClickHandlerClass();
        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(clickHandlerClass);

        Log.i("btn","button: "+button.getId());
        Log.i("btn","button: "+R.id.button1);

        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(clickHandlerClass);
    }

    class ClickHandlerClass implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Log.w("btn","Id of clicked button is: "+view.getId());
            Log.w("btn","Button clicked.");
        }
    }
}
