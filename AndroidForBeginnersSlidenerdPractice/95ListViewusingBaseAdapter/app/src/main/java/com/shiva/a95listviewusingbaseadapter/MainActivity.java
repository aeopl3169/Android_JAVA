package com.shiva.a95listviewusingbaseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listView);
        ViewBaseAdapter viewBaseAdapter = new ViewBaseAdapter(this);
        listView.setAdapter(viewBaseAdapter);
    }
}

class ViewBaseAdapter extends BaseAdapter{
    ArrayList<SingleRow> list;
    Context context;
    ViewBaseAdapter(Context context)
    {
        this.context = context;
        list = new ArrayList<SingleRow>();

        Resources resources = context.getResources();
        String[] titles = resources.getStringArray(R.array.titles);
        String[] description = resources.getStringArray(R.array.descriptions);
        int[] images = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_6, R.drawable.img_7, R.drawable.img_8, R.drawable.img_9, R.drawable.img_10, R.drawable.img_11, R.drawable.img_12};
        for (int i=0; i<12; i++){
            list.add(new SingleRow(titles[i], description[i], images[i]));
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    // This method is used when database are attached.
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.single_row,viewGroup,false);

        TextView textViewTitles = (TextView)view1.findViewById(R.id.textViewTitles);
        TextView textViewDescription = (TextView)view1.findViewById(R.id.textViewDescription);
        ImageView imageView = (ImageView)view1.findViewById(R.id.imageView);

        SingleRow temp = list.get(i);

        textViewTitles.setText(temp.title);
        textViewDescription.setText(temp.description);
        imageView.setImageResource(temp.image);

        return view1;
    }
}

class SingleRow {
    String title;
    String description;
    int image;
    SingleRow(String title, String description, int image){
        this.title = title;
        this.description = description;
        this.image = image;
    }
}