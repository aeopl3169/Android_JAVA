package com.shiva.fetchingdatafrommysqlphp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AsyncBackground2 extends AsyncTask<Void, Void, String> {

    Context context;
    RequestQueue requestQueue;

    public AsyncBackground2(Context context) {
        this.context = context;

//        fetchViaVolley();
    }

    @Override
    protected String doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, "JSON: " + s, Toast.LENGTH_LONG).show();
    }
}