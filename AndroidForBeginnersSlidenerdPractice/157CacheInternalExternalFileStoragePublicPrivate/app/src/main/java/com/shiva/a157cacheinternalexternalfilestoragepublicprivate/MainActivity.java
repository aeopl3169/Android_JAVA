package com.shiva.a157cacheinternalexternalfilestoragepublicprivate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
//    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }

    // Cache is stored in View --> Tool Windows --> Device File Explorer --> data -> data -> "package Name".
    public void saveCacheInternal(View view) {
        String data = editText.getText().toString();
        File file = getCacheDir();
        File myFile = new File(file, "MyFile1");
        createFile(data,myFile);
    }
    // Cache is stored in: View --> Tool Windows --> Device File Explorer --> storage -> self -> primary -> Android -> data -> "package name"
    public void saveCacheExternal(View view) {
        String data = editText.getText().toString();
        File file = getExternalCacheDir();
        File myFile = new File(file, "MyFile2");
        createFile(data,myFile);
    }

    public void saveFileStoragePrivate(View view) {
        String data = editText.getText().toString();
        File file = getExternalFilesDir("SHIVA");
        File myFile = new File(file, "MyFile3");
        createFile(data,myFile);
    }

    public void saveFileStoragePublic(View view) {
        String data = editText.getText().toString();
//        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File file = this.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        File myFile = new File(file, "MyFile4.txt");
        createFile(data,myFile);
    }

    public void createFile(String data, File myFile){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(this,data+" is stored at: "+myFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
            Log.d("DATA",data+" is stored at: "+myFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileOutputStream !=null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openAnotherActivity(View view) {
        startActivity(new Intent(this, AnotherActivity.class));
    }
}