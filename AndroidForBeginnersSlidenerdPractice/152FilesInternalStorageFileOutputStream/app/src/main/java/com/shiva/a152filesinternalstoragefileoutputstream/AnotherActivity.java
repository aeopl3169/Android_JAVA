package com.shiva.a152filesinternalstoragefileoutputstream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AnotherActivity extends AppCompatActivity {

    EditText editTextGetUserName, editTextGetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        editTextGetUserName = findViewById(R.id.editTextGetUserName);
        editTextGetPassword = findViewById(R.id.editTextGetPassword);
    }

    public void load(View view) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("store.txt");
            int readValue = -1;
            StringBuffer stringBuffer = new StringBuffer();
            // fileInputStream.read() will read single character in the file(store.txt)
            while ((readValue = fileInputStream.read()) != -1) {
//                Log.d("FILE","readValue: "+fileInputStream.read());
                Log.d("FILE"," character: "+(char)readValue);
                stringBuffer.append((char) readValue);
            }
            Log.d("FILE", stringBuffer.toString());
            String text1 = stringBuffer.substring(0, stringBuffer.indexOf(" "));
            String text2 = stringBuffer.substring(stringBuffer.indexOf(" ")+1);

            editTextGetUserName.setText(text1);
            editTextGetPassword.setText(text2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}