package com.shiva.pillu.a187asynctaskdownloadimagerotationtechnique;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    EditText editText;
    ProgressBar progressBar;
    ImageView imageView;
    ListView listView;
    String[] imagesUrl, urlTitle;
    ArrayAdapter<String> arrayAdapter;
    NonUITaskFragment nonUITaskFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        editText = findViewById (R.id.edit_text);
        progressBar = findViewById (R.id.progress_bar);
        imageView = findViewById (R.id.image_view);
        listView = findViewById (R.id.list_view);

        imagesUrl = getResources ().getStringArray (R.array.imageUrl);
        urlTitle = getResources ().getStringArray (R.array.names);

        arrayAdapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, urlTitle);
        listView.setAdapter (arrayAdapter);
        listView.setOnItemClickListener (this);
        progressBar.setIndeterminate (true);
        if (savedInstanceState == null) {
            nonUITaskFragment = new NonUITaskFragment (this);
            getSupportFragmentManager ().beginTransaction ().add (nonUITaskFragment, "TaskFragment").commit ();
        } else {
            nonUITaskFragment = (NonUITaskFragment) getSupportFragmentManager ().findFragmentByTag ("TaskFragment");
        }
        // Checking fragment not null
        if (nonUITaskFragment != null) {
            // First asyncTask not equal to null && second asyncTask is running or not.
            if (nonUITaskFragment.asyncTaskDownload != null && nonUITaskFragment.asyncTaskDownload.getStatus () == AsyncTask.Status.RUNNING) {
                progressBar.setVisibility (View.VISIBLE);
            }
        }
    }

    public void setImage(Bitmap bitmap){
        imageView.setImageBitmap (bitmap);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        editText.setText (imagesUrl[i]);
        nonUITaskFragment.beginTaskMethod (editText.getText ().toString ());
    }

    public void updateProgress(int progress) {
        progressBar.setProgress (progress);
    }

    public void showProgressBarBeforeDownloading() {
        if (nonUITaskFragment.asyncTaskDownload != null) {
            // First condition, should not be visible && second condition, progress bar should not be 100% full.
            if (progressBar.getVisibility () != View.VISIBLE && progressBar.getProgress () != progressBar.getMax ()) {
                // Showing the progress bar.
                progressBar.setVisibility (View.VISIBLE);
            }
        }
    }

    public void hideProgressBarAfterDownloading() {
        if (nonUITaskFragment.asyncTaskDownload != null) {
            if (progressBar.getVisibility () == View.VISIBLE) {
                progressBar.setVisibility (View.GONE);
            }
        }
    }
}