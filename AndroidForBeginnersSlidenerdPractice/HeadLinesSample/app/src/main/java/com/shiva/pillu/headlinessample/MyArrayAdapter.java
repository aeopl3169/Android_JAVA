package com.shiva.pillu.headlinessample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class MyArrayAdapter extends ArrayAdapter<HashMap<String, String>> {

    private Context context;
    private int resource;
    private ArrayList<HashMap<String, String>> data;
    private HashMap<String, String> hashMap;

    public MyArrayAdapter(@NonNull Context context, int resource, ArrayList<HashMap<String, String>> data) {
        super (context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate (resource, parent, false);

        Holder holder =new Holder();
        holder.textViewTitle =(TextView)view.findViewById (R.id.text_view_title);
        hashMap = data.get (position);
        holder.textViewTitle.setText (hashMap.get ("title"));
        return view;
    }
    public class Holder{
        TextView textViewTitle;
    }
}