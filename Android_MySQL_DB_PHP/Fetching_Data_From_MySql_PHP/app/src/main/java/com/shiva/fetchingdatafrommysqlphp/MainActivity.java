package com.shiva.fetchingdatafrommysqlphp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    //    String webServiceUrl = "http://10.0.2.2/fetch_data/fetch.php"; // URL working in emulator.
    String webServiceUrl = "http://192.168.0.8/fetch_data/fetch.php";
    ListView listView;
    ClassAdapter classAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
//        requestQueue = VolleySingletonClass.getInstanceMethod (this).getRequestQueueMethod ();
//        AsyncBackground2 asyncBackground = new AsyncBackground2(this);
        AsyncBackground asyncBackground = new AsyncBackground(this);
        asyncBackground.execute();
//        Fetch.fetchViaVolley();
//        fetchViaVolley ();
        listView = findViewById (R.id.listView);

    }

    public void fetchViaVolley() {
        StringBuilder stringBuilder = new StringBuilder ();
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest (Request.Method.GET, webServiceUrl, (JSONArray) null,
                new Response.Listener<JSONArray> () {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d ("FETCH", "Response: " + response);
                        try {
                            for (int i = 0; i < response.length (); i++) {
                                JSONObject jsonObject = response.getJSONObject (i);

                                Person person = new Person ();
                                person.id = jsonObject.getInt ("id");
                                person.name = jsonObject.getString ("name");

                                personsArrayList.add (person);
                                if(classAdapter == null) {
                                    classAdapter = new ClassAdapter ();
                                }
                                listView.setAdapter (classAdapter);

                                int id = jsonObject.getInt ("id");
                                String name = jsonObject.getString ("name");
                                Log.d ("FETCH", "ID: " + id + " name: " + name);
                            }
                        } catch (Exception e) {
                            e.printStackTrace ();
                        }
                    }
                },
                new Response.ErrorListener () {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e ("FETCH", "Error: " + error);
                    }
                });
        requestQueue.add (jsonArrayRequest);
    }

    // Array list
    ArrayList<Person> personsArrayList = new ArrayList<Person> ();

    // Result object
    class Person {
        public String name;
        public int id;
    }

    // To temporarily hold JSON data, we user this below array list of type string
    static ArrayList<String> resultRow;
    class ClassAdapter extends ArrayAdapter<MainActivity.Person> {
        Context context;
        int[] intArrayId;
        String[] stringArrayName;

        public ClassAdapter() {
            super (MainActivity.this,R.layout.row, personsArrayList);
            this.context = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate (R.layout.row, parent, false);
            }

            TextView textViewId = view.findViewById (R.id.textViewId);
            TextView textViewName = view.findViewById (R.id.textViewName);

            textViewId.setText (intArrayId[position]);
            textViewName.setText (stringArrayName[position]);
            return view;
        }
    }
}