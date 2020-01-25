package com.shiva.selftest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncTaskHandler extends AsyncTask<String, String, String> {

    Context context;
    ProgressDialog progressDialog;

    public AsyncTaskHandler(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Loading...");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection httpURLConnection = null;
        URL url = null;
        String results = null;
        try {
            url = new URL("http://192.168.2.93/sample.php");
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setDoOutput(true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            int response = httpURLConnection.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                if ((results = bufferedReader.readLine()) != null) {
                    stringBuffer.append(results);
                }
                return results;
            } else {
                return ("Unsuccesful");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    protected void onPostExecute(String s) {
        progressDialog.hide();
        Toast.makeText(context, "" + s, Toast.LENGTH_LONG).show();
    }
}