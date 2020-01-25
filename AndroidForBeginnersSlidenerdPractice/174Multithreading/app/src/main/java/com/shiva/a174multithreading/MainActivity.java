package com.shiva.a174multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    Button button;
    ProgressBar progressBar;
    TextView textView;
    ImageView imageView;
    ListView listView;
    LinearLayout linearLayout = null;
    String[] imagesUrl, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById (R.id.imageView);
        imagesUrl = getResources().getStringArray(R.array.imageUrl);
        url = getResources().getStringArray(R.array.url);
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, url);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        editText.setText(imagesUrl[i]);
    }

    public void downloadImage(View view) {
//        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//        Log.w("THREAD", " "+file.getAbsolutePath());
//        String url = listOfImages[0];
//        Uri uri = Uri.parse(url);
//        Log.d("THREAD", " "+uri.getLastPathSegment());
        String url = editText.getText().toString();
        Thread thread = new Thread(new DownloadImageThread(url));
        thread.start();
    }

    private class DownloadImageThread implements Runnable {
        String url;
        public DownloadImageThread(String url){
            this.url = url;
        }
        @Override
        public void run() {
            downloadImageUsingThreads(url);
//            imageView.setImageBitmap(bmp);
            Log.d("THREAD", "URL: "+url);
        }

    }
    Bitmap bmp;
    public Bitmap downloadImageUsingThreads(String url) {
        boolean successful = false;
        URL downloadURL = null;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        File file1, file2 = null;

        try {
            // url is constructed.
            downloadURL = new URL(url);
            // opening URL connection.
            httpURLConnection = (HttpURLConnection) downloadURL.openConnection();
            httpURLConnection.connect ();
            // opening input stream.
            inputStream = httpURLConnection.getInputStream();

            BufferedInputStream bufferedInputStream = new BufferedInputStream (inputStream);
            bmp = BitmapFactory.decodeStream (bufferedInputStream);
//            imageView.setImageBitmap (bmp);

            file1 = this.getExternalFilesDir(Environment.DIRECTORY_DCIM);
            // creating file object
            file2 = new File(file1.getAbsolutePath()+"/"+Uri.parse(url).getLastPathSegment());
            Log.d("THREAD", "File path: "+file2.getAbsolutePath());
            fileOutputStream = new FileOutputStream(file2);
            int read = -1;
            byte[] buffer = new byte[1024];
            while ((read=inputStream.read(buffer))!= -1){
                // writing to output stream.
                fileOutputStream.write(buffer,0,read);
                Log.d("THREAD", " "+read);
            }
            successful = true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("THREAD", " "+e);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("THREAD", " "+e);
        } finally {
            if (httpURLConnection!=null){
                httpURLConnection.disconnect();
            }
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e("THREAD", " "+e);
                }
            }
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("THREAD", " "+e);
                }
            }
        }
        return bmp;
    }

    private class MyThread2 extends Thread{

    }
}