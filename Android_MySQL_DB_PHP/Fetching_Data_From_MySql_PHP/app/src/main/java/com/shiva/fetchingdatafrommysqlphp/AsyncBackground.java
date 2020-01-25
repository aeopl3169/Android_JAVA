package com.shiva.fetchingdatafrommysqlphp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncBackground extends AsyncTask<Void, Void, String> {
//    String WebServiceUrl = "http://10.0.2.2/fetch_data/fetch.php"; // URL working in emulator.
    String WebServiceUrl = "http://192.168.42.85/fetch_data/fetch.php";

    Context context;

    public AsyncBackground(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            //creating a URL
            URL url = new URL(WebServiceUrl);// to connect to PHP file.

            //Opening the URL using HttpURLConnection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            //StringBuilder object to read the string from the service
            StringBuilder stringBuilder = new StringBuilder();

            //We will use a buffered reader to read the string from service
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream())); //java.net.NoRouteToHostException: Host unreachable

            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                stringBuilder.append(temp + "\n");
            }
            return stringBuilder.toString().trim();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context,"JSON: "+s, Toast.LENGTH_LONG).show();
    }
}