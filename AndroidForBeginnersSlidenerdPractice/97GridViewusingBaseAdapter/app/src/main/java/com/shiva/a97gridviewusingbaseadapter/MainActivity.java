package com.shiva.a97gridviewusingbaseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView= (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new SimpleBaseAdpater(this));
    }
}

class EachViewInGrid{
    String titles;
    int images;
    public EachViewInGrid(String titles, int images) {
        this.titles = titles;
        this.images = images;
    }
}

class SimpleBaseAdpater extends BaseAdapter{
    Context context;
    ArrayList<EachViewInGrid> arrayListeachViewinGrid;
    SimpleBaseAdpater(Context context){
        this.context = context;
        Resources resources = context.getResources();
        String[] titles = resources.getStringArray(R.array.titles);
        int[] images = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_6, R.drawable.img_7, R.drawable.img_8, R.drawable.img_9, R.drawable.img_10, R.drawable.img_11, R.drawable.img_12};
        arrayListeachViewinGrid = new ArrayList<EachViewInGrid>();
        for (int i=0; i<12; i++) {
            arrayListeachViewinGrid.add(new EachViewInGrid(titles[i],images[i]));
        }
    }
    @Override
    public int getCount() {
        return arrayListeachViewinGrid.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListeachViewinGrid.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewGrid = layoutInflater.inflate(R.layout.single_view,viewGroup,false);
        TextView textView = (TextView)viewGrid.findViewById(R.id.textViewTitles);
        ImageView imageView = (ImageView)viewGrid.findViewById(R.id.imageView);
        EachViewInGrid temp = arrayListeachViewinGrid.get(i);
        textView.setText(temp.titles);
        imageView.setImageResource(temp.images);
        return viewGrid;
    }
}