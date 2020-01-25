package com.shiva.a163sqlitedatabaseinsertquery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUserName, editTextPassword;
    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);

        databaseAdapter = new DatabaseAdapter(this);
    }

    public void insert(View view) {
        String user = editTextUserName.getText().toString();
        String pass = editTextPassword.getText().toString();
        long id = databaseAdapter.insertData(user, pass);
        if (id < 0) {
            Toast.makeText(this, "UnSuccessfull", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Successfull", Toast.LENGTH_SHORT).show();
        }
    }
}