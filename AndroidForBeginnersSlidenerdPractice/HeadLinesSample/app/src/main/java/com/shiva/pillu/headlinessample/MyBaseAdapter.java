package com.shiva.pillu.headlinessample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyBaseAdapter extends BaseAdapter {
    ArrayList<HashMap<String, String>> data;
    LayoutInflater layoutInflater;
    private Communicator mCommunicator;
    Context context;

    public MyBaseAdapter(Context context, ArrayList<HashMap<String, String>> data) {
        this.data = data;
        this.context = context;
        Log.d ("XML","MyBaseAdapter: "+data);
//        layoutInflater = (LayoutInflater) context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
    }

    public void send(ArrayList<HashMap<String, String>> results){
        Log.d ("XML","MyBaseAdapter send method: "+data);
    }

    @Override
    public int getCount() {
        return data.size ();
    }

    @Override
    public Object getItem(int i) {
        return data.get (i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = view;
        MyRowHolder myRowHolder = null;

//        if (view1 == null) {
//            view1 = LayoutInflater.from (viewGroup.getContext ()).inflate (R.layout.single_row, viewGroup, false);
//            myRowHolder = new MyRowHolder (view1);
//            view1.setTag (myRowHolder);
//        }

            if (view1 == null) {
                layoutInflater = (LayoutInflater)context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
                view1 = layoutInflater.inflate (R.layout.single_row, viewGroup, false);
                myRowHolder = new MyRowHolder (view1);
                view1.setTag (myRowHolder);
            }
        else {
            myRowHolder = (MyRowHolder) view1.getTag ();
        }
        HashMap<String, String> currentItem = data.get (i);
        myRowHolder.textViewTitle.setText (currentItem.get ("title"));
        return view1;
    }
}

class MyRowHolder {
    TextView textViewTitle;

    public MyRowHolder(View view) {
        textViewTitle = view.findViewById (R.id.text_view_title);
    }
}