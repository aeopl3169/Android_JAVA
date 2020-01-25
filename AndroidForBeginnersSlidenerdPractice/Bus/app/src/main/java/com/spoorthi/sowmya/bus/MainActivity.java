package com.spoorthi.sowmya.bus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextBusNo, editTextRouteNo, editTextFrom, editTextTo, editTextDate, editTextTime, editTextDriverNo;
    DataBaseAdapter dataBaseAdapter;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBusNo = findViewById(R.id.editTextBusNo);
        editTextRouteNo = findViewById(R.id.editTextRouteNo);
        editTextFrom = findViewById(R.id.editTextFrom);
        editTextTo = findViewById(R.id.editTextTo);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextDriverNo = findViewById(R.id.editTextDriverNo);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(this);
        dataBaseAdapter = new DataBaseAdapter(this);
    }

    public void insert(View view) {

    }

    @Override
    public void onClick(View view) {
        String busNo = editTextBusNo.getText().toString();
        String routeNo = editTextRouteNo.getText().toString();
        String from = editTextFrom.getText().toString();
        String to = editTextTo.getText().toString();
        String date = editTextDate.getText().toString();
        String time = editTextTime.getText().toString();
        String driverNo = editTextDriverNo.getText().toString();
        long id = dataBaseAdapter.insertRecored(busNo, routeNo, from, to, date, time, driverNo);
        Toast.makeText(this, "Submitted: " + id, Toast.LENGTH_LONG).show();
    }

    public void viewRecords(View view) {
        StringBuffer record = dataBaseAdapter.viewAllRecords();
//        Toast.makeText(this,""+record,Toast.LENGTH_LONG).show();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("LIST");
        alertDialogBuilder.setMessage(""+record);
        alertDialogBuilder.show();
    }
}