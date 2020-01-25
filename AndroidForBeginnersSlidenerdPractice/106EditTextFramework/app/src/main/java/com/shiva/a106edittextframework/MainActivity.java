package com.shiva.a106edittextframework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == EditorInfo.IME_ACTION_DONE) {
            Toast.makeText(this, "Yes! Done.", Toast.LENGTH_LONG).show();
            return true;
        } else if (i== EditorInfo.TYPE_CLASS_NUMBER){
            Toast.makeText(this, "Number", Toast.LENGTH_LONG).show();
            return true;
        } else if(i==EditorInfo.IME_ACTION_SEARCH){
            Toast.makeText(this, "Search.", Toast.LENGTH_LONG).show();
            return true;
        }

        return false;
    }
}
