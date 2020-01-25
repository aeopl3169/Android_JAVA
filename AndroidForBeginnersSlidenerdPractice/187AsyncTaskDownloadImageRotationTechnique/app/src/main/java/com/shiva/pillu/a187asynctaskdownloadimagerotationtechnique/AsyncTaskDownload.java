package com.shiva.pillu.a187asynctaskdownloadimagerotationtechnique;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncTaskDownload extends AsyncTask<String, Integer, Bitmap> {

    private int contentLength = -1;
    private int count = 0;
    private Context context;
    private int calculatedProgress = 0;

    public AsyncTaskDownload(Context context) {
        onAttachMethod (context);
    }

    // If the screen is rotated, the activity and fragment is destroyed.
    // Here the context will be saved and used while rotation.
    public void onAttachMethod(Context context) {
        this.context = context;
    }

    public void onDetachMethod() {
        context = null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute ();
        if (context == null){
            Log.d ("ASYNC","Device rotated, activity is destroyed and context is null.");
        } else {
            ((MainActivity) context).showProgressBarBeforeDownloading ();
        }
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        boolean successful = false;
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;
        //for (String temp : strings) {
            try {
                url = new URL (strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection ();
                httpURLConnection.connect ();
                // getContentLength returns length of the image file.
                contentLength = httpURLConnection.getContentLength ();
                Log.d ("ASYNC", "doInBackground - contentLength: " + contentLength);
                inputStream = httpURLConnection.getInputStream ();
                BufferedInputStream bufferedInputStream = new BufferedInputStream (inputStream);
                Bitmap bitmap = BitmapFactory.decodeStream (bufferedInputStream);

                // Progress bar
                Log.i ("ASYNC", "doInBackground: " + strings);
                file = new File (context.getExternalFilesDir (
                        Environment.DIRECTORY_PICTURES).getAbsolutePath ()
                        + "/" + Uri.parse (strings[0]).getLastPathSegment ());
                fileOutputStream = new FileOutputStream (file);
                Log.d ("ASYNC", "path: " + file.getAbsolutePath ());
                int read = -1;
                byte[] buffer = new byte[1024];
                while ((read = inputStream.read (buffer)) != -1) {
                    fileOutputStream.write (buffer, 0, read);
                    count = count + read;
                    Log.i ("ASYNC", "count: " + count + " Count Lenght: " + contentLength);
                    publishProgress (count);
                }
                return bitmap;
            } catch (MalformedURLException e) {
                e.printStackTrace ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
//        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate (values);
        if (context == null){
            Log.d ("ASYNC","Device rotated, activity is destroyed and context is null.");
        } else {
            calculatedProgress = (int)(((double)values[0]/contentLength)*100);
            ((MainActivity) context).updateProgress (calculatedProgress);
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute (bitmap);
        ((MainActivity) context).hideProgressBarAfterDownloading ();
        ((MainActivity)context).setImage (bitmap);
//        imageView.setImageBitmap (bitmap);
    }
}