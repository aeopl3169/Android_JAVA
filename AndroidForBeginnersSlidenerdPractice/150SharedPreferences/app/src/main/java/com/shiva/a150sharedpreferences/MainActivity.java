package com.shiva.a150sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText editTextUserName, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void saveMethod(View view) {
        // The SharedPreferences are stored in /data/user/0/"app package name"/shared_prefs/"file name"
        // To locate go to View --> Tool Windows --> Device File Explorer.
        SharedPreferences sharedPreferences = getSharedPreferences("MyDataToSave", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("usrNam", editTextUserName.getText().toString());
        editor.putString("pass", editTextPassword.getText().toString());
        editor.commit();

        // to get the location of file.
        File file = getFilesDir();
        Log.d("DIR", "Location: " + file);
        startActivity(new Intent(this, AnotherActivity.class));
    }
}
