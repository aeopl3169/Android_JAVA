package com.shiva.a242jsonvolley;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MyFragment extends Fragment {
    TextView textView;

    public static MyFragment getInstanceMethod(int position) {
        MyFragment myFragment = new MyFragment();
        Bundle bundleArgs = new Bundle();
        bundleArgs.putInt("position", position);
        myFragment.setArguments(bundleArgs);
        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        textView = (TextView)view.findViewById(R.id.textView);
        Bundle bundle = getArguments();
        if (bundle!=null){
            textView.setText("The page selected is: "+bundle.getInt("position"));
        }
        // Instantiate the RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        //Request a string response from the provided URL.
        String url ="http://www.google.com";
        String url2 = "http://php.net/";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(), "Listener", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
        return view;
    }
}