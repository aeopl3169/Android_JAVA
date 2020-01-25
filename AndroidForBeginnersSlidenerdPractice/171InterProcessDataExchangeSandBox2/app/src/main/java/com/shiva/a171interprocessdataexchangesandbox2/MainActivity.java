package com.shiva.a171interprocessdataexchangesandbox2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    private final String packageName = "com.shiva.a171interprocessdataexchangesandbox";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
    }

    public void loadData(View view) {
        PackageManager packageManager = getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager
                    .getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            String fullPath = applicationInfo.dataDir+"/files/shiva.txt";
            readFile(fullPath);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            textView.setTextColor(Color.RED);
            textView.setText(e+" ");
        }
    }

    public void readFile(String fullPath){
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(new File(fullPath));
            int read = -2;
            StringBuffer stringBuffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1){
                stringBuffer.append((char)read);
            }
            editText.setText(stringBuffer);
            textView.setText(fullPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            textView.setText(e+"");
        } catch (IOException e) {
            e.printStackTrace();
            textView.setText(e+"");
        }
    }
}