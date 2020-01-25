package com.shiva.fetchingdatafrommysqlphp;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Fetch {
    //    String webServiceUrl = "http://10.0.2.2/fetch_data/fetch.php"; // URL working in emulator.
    static final String webServiceUrl = "http://172.16.5.137/fetch_data/fetch.php";
    static RequestQueue requestQueue;
    static Context context;

    public Fetch(Context context) {
        this.context = context;
    }

    public static void fetchViaVolley() {
        final StringBuilder stringBuilder = new StringBuilder();
        requestQueue = VolleySingletonClass.getInstanceMethod(context).getRequestQueueMethod();
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, webServiceUrl, (JSONObject) null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int id = jsonObject.getInt("id");
                                String name = jsonObject.getString("name");
                                //StringBuilder object to read the string from the service
                                stringBuilder.append(id + " " + name);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("FETCH", "Error: " + error);
                    }
                });
    }

}
