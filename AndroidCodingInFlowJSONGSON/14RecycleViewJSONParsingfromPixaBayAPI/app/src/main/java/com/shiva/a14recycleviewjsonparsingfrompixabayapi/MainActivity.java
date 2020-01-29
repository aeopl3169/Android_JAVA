package com.shiva.a14recycleviewjsonparsingfrompixabayapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterClass adapterClass;
    private ArrayList<SingleItemCartView> singleItemCartViewArrayList;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);// By setting it fixed, performance will improve.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        singleItemCartViewArrayList = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        parseJsonMethod();
    }

    private void parseJsonMethod() {
        String url = "https://pixabay.com/api/?key=13347812-ea5e76577f1ac4a82b51b04c7&q=yellow+flowers&image_type=photo&pretty=true";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");
                            for (int i = 0; i <= jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String userCreator = jsonObject.getString("user");
                                String url = jsonObject.getString("webformatURL");
                                int likes = jsonObject.getInt("likes");
                                singleItemCartViewArrayList.add(new SingleItemCartView(userCreator, url, likes));
                            }
                            // To fill the recycle view, adapter is created.
                            adapterClass = new AdapterClass(MainActivity.this, singleItemCartViewArrayList);
                            recyclerView.setAdapter(adapterClass);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }
}
