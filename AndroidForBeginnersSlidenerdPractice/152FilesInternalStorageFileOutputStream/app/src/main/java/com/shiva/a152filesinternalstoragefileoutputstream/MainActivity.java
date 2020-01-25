package com.shiva.a152filesinternalstoragefileoutputstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editTextUserName, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void save(View view) {
        // converting text to string.
        String stringUserName = editTextUserName.getText().toString();
        FileOutputStream fileOutputStream = null;
        try {
            // Files will be storing in text format, compulsory give .txt extension.
            fileOutputStream = openFileOutput("store.txt", Context.MODE_APPEND);
            fileOutputStream.write(stringUserName.getBytes());// Converting string to bytes.
            fileOutputStream.write(editTextPassword.getText().toString().getBytes());// Converting text to string to bytes in one line.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        startActivity(new Intent(this, AnotherActivity.class));
    }
}