package com.shiva.a73edittextvalidationtextwatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText)findViewById(R.id.editText);
        editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Toast.makeText(this,"Before text change", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Toast.makeText(this,"On text change", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterTextChanged(Editable editable) {
        Toast.makeText(this,"After text change", Toast.LENGTH_SHORT).show();

        try {
            // If the user backspace the number entered, this(Integer.parseInt(editable.toString())) may throw exception.
            // To avoid exception use try catch.
            int a = Integer.parseInt(editable.toString());
            if (a > 100){
                editable.replace(0,editable.length(),"100");
            }
        }
        catch (NumberFormatException e){}
    }
}
