package com.shiva.a168sqlitedatabaseupdatedelete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextAddress, editTextOldName, editTextNewName, editTextDeleteRow;
    DataBaseAdapter dataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextOldName = findViewById(R.id.editTextOldName);
        editTextNewName = findViewById(R.id.editTextNewName);
        editTextDeleteRow = findViewById(R.id.editTextDeleteRow);

        dataBaseAdapter = new DataBaseAdapter(this);
    }

    public void insertData(View view) {
        String name = editTextName.getText().toString();
        String address = editTextAddress.getText().toString();
        long id = dataBaseAdapter.insertRecored(name, address);
        Toast.makeText(this,"Row inserted: "+id,Toast.LENGTH_LONG).show();
    }

    public void viewAllData(View view) {
        StringBuffer record = dataBaseAdapter.viewAllRecords();
        Toast.makeText(this,""+record,Toast.LENGTH_LONG).show();
    }

    public void updateName(View view) {
        String oldName = editTextOldName.getText().toString();
        String newName = editTextNewName.getText().toString();
        int id = dataBaseAdapter.updateRecord(oldName, newName);
        Toast.makeText(this,"Row updated: "+id,Toast.LENGTH_LONG).show();
    }

    public void delete(View view) {
        String delete = editTextDeleteRow.getText().toString();
        int id = dataBaseAdapter.deleteRecore(delete);
        Toast.makeText(this,"Deleted row : "+id,Toast.LENGTH_LONG).show();
    }
}
