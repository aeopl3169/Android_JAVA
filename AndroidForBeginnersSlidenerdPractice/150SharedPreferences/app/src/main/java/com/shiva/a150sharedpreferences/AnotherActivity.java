package com.shiva.a150sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AnotherActivity extends AppCompatActivity {

    EditText editTextUN, editTextPass;
    public static final String DEFAULT = "N/A";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);
        editTextUN = findViewById(R.id.editTextUN);
        editTextPass = findViewById(R.id.editTextPass);
    }

    public void getMethod(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyDataToSave", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("usrNam", DEFAULT);
        String password = sharedPreferences.getString("pass", DEFAULT);

        if (userName.equals(DEFAULT) || password.equals(DEFAULT)) {
            Toast.makeText(this, "No Value Passed.", Toast.LENGTH_LONG).show();
        }

        editTextUN.setText(userName);
        editTextPass.setText(password);


    }
}
