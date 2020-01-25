package com.shiva.pillu.headlines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyBaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<HashMap<String, String>> data;
    LayoutInflater layoutInflater;

    public MyBaseAdapter(Context context, ArrayList<HashMap<String, String>> data) {
        this.context = context;
        this.data = data;
        layoutInflater = (LayoutInflater) context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
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
        if (view1 == null) {
            view1 = layoutInflater.inflate (R.layout.single_row, viewGroup, false);
            myRowHolder = new MyRowHolder (view1);
            view1.setTag (myRowHolder);
        } else {
            myRowHolder = (MyRowHolder) view1.getTag ();
        }
        HashMap<String, String> currentItem = data.get (i);
        myRowHolder.textViewTitle.setText (currentItem.get ("title"));
        return view1;
    }
}

class MyRowHolder {
    TextView textViewTitle;
    TextView textViewPublishDate;
    ImageView imageView;
    TextView textViewDescription;

    public MyRowHolder(View view) {
        textViewTitle = view.findViewById (R.id.text_view_title);
        textViewPublishDate = view.findViewById (R.id.text_view_date);
        imageView = view.findViewById (R.id.image_view);
        textViewDescription = view.findViewById (R.id.text_view_description);
    }
}