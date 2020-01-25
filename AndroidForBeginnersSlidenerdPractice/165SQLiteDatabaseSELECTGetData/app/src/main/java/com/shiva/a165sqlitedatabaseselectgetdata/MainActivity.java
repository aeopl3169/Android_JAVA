package com.shiva.a165sqlitedatabaseselectgetdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUserName, editTextPassword, editTextFindByName;
    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextFindByName = findViewById(R.id.editTextFindByName);

        databaseAdapter = new DatabaseAdapter(this);
    }

    public void insert(View view) {
        String name = editTextUserName.getText().toString();
        String pass = editTextPassword.getText().toString();

        long id = databaseAdapter.insertRow(name, pass);
        Toast.makeText(this, "" + id, Toast.LENGTH_LONG).show();
    }

    public void getDetails(View view) {
        String completeData = databaseAdapter.getAllValues();
        Toast.makeText(this, "" + completeData, Toast.LENGTH_LONG).show();
    }

    public void getParticularDetails(View view) {
        String name = editTextFindByName.getText().toString();
        String particularValue = databaseAdapter.getParticularValues(name);
        Toast.makeText(this,""+particularValue,Toast.LENGTH_LONG).show();
    }

}