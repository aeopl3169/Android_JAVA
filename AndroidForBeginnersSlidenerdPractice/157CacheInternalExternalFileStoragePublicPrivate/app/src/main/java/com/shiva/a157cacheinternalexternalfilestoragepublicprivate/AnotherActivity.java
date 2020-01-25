package com.shiva.a157cacheinternalexternalfilestoragepublicprivate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AnotherActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        editText = findViewById(R.id.editTextGet);
    }

    public void getCacheInternal(View view) {
        File file = getCacheDir();
        File myFile = new File(file, "MyFile1");
        String data = readData(myFile);
        check(data);
    }

    public void getCacheExternal(View view) {
        File file = getExternalCacheDir();
        File myFile = new File(file, "MyFile2");
        String data = readData(myFile);
        check(data);
    }

    public void getFileStoragePrivate(View view) {
        File file = getExternalFilesDir("SHIVA");
        File myFile = new File(file, "MyFile3");
        String data = readData(myFile);
        check(data);
    }

    public void getFileStoragePublic(View view) {
//        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File file = this.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        File myFile = new File(file, "MyFile4.txt");
        String data = readData(myFile);
        check(data);
    }

    public String readData(File myFile) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(myFile);
            int read = -1;
            StringBuffer stringBuffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1) {
                stringBuffer.append((char) read);
            }
            return stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void check(String data){
        if (data != null) {
            editText.setText(data);
        }
    }
}