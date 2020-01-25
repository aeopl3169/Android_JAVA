package com.shiva.a185asynctaskdownloadimages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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
import android.widget.Button;
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
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        editText.setText (imagesUrl[i]);
        AsyncDownloadTask asyncDownloadTask = new AsyncDownloadTask ();
        asyncDownloadTask.execute (imagesUrl[i]);
    }

    private class AsyncDownloadTask extends AsyncTask<String, Integer, Bitmap> {

        private int contentLength = -1;
        private int count = 0;

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility (View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            URL url = null;
            HttpURLConnection httpURLConnection = null;
            File file;
            FileOutputStream fileOutputStream = null;

            for (String temp : strings) {
                try {
                    url = new URL (temp);
                    httpURLConnection = (HttpURLConnection) url.openConnection ();
                    httpURLConnection.connect ();
                    // getContentLength returns length of the image file.
                    contentLength = httpURLConnection.getContentLength ();
                    Log.d ("ASYNC", "doInBackground - contentLength: " + contentLength);
                    InputStream inputStream = httpURLConnection.getInputStream ();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream (inputStream);
                    Bitmap bitmap = BitmapFactory.decodeStream (bufferedInputStream);

                    // Progress bar
                    Log.i ("ASYNC", "doInBackground: " + temp);
                    file = new File (MainActivity.this.getExternalFilesDir(
                            Environment.DIRECTORY_PICTURES).getAbsolutePath ()
                            + "/" + Uri.parse (strings[0]).getLastPathSegment ());
                    fileOutputStream = new FileOutputStream (file);
                    Log.d ("ASYNC", "path: " + file.getAbsolutePath ());
                    int read = -1;
                    byte[] buffer = new byte[1024];
                    while ((read = inputStream.read (buffer)) != -1) {
                        fileOutputStream.write (buffer, 0, read);
                        count = count + read;
                        Log.i ("ASYNC", "count: " + count+" Count Lenght: "+contentLength);
                        publishProgress (count);
                    }
                    return bitmap;
                } catch (MalformedURLException e) {
                    e.printStackTrace ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i ("ASYNC", "onProgressUpdate: " + values);

        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap (bitmap);
            progressBar.setVisibility (View.GONE);
        }
    }
}