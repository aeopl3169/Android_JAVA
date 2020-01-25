package com.shiva.a101listviewusingbaseadapteroptimization;

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
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        ClassAdapter classAdapter = new ClassAdapter(this);
        gridView.setAdapter(classAdapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, DialogActivity.class);
        ViewHolder viewHolder = (ViewHolder)view.getTag();
        EachGrid temp = (EachGrid) viewHolder.imageView.getTag();// Getting the
        intent.putExtra("image", temp.images);
        intent.putExtra("titles", temp.titles);
        startActivity(intent);
    }
}

class EachGrid {
    String titles;
    int images;

    EachGrid(String titles, int images) {
        this.titles = titles;
        this.images = images;
    }
}

class ClassAdapter extends BaseAdapter {
    ArrayList<EachGrid> eachGridArrayList;
    Context context;
    String[] titles;
    int[] images;

    ClassAdapter(Context context) {
        this.context = context;
        Resources resources = context.getResources();
        titles = resources.getStringArray(R.array.titles);
        images = new int[]{R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_6, R.drawable.img_7, R.drawable.img_8, R.drawable.img_9, R.drawable.img_10, R.drawable.img_11, R.drawable.img_12};
        eachGridArrayList = new ArrayList<EachGrid>();
        for (int i = 0; i < 12; i++) {
            eachGridArrayList.add(new EachGrid(titles[i], images[i]));
        }
    }

    @Override
    public int getCount() {
        return eachGridArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return eachGridArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = view;
        ViewHolder viewHolder = null;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view1 = layoutInflater.inflate(R.layout.each_grid, viewGroup, false);

            viewHolder = new ViewHolder(view1);// Pass the inflated view.
            view1.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view1.getTag();
        }

//        viewHolder.textView.setText(titles[i]);
//        viewHolder.imageView.setImageResource(images[i]);

        EachGrid temp = eachGridArrayList.get(i);
        viewHolder.textView.setText(temp.titles);
        viewHolder.imageView.setImageResource(temp.images);
        viewHolder.imageView.setTag(temp);// This setTeg method is set to retrieve on onItemClick listener and send via intent to another activity.
        return view1;
    }
}
class ViewHolder {
    TextView textView;
    ImageView imageView;

    ViewHolder(View view) {
        textView = (TextView) view.findViewById(R.id.textView);
        imageView = (ImageView) view.findViewById(R.id.imageView);
    }
}