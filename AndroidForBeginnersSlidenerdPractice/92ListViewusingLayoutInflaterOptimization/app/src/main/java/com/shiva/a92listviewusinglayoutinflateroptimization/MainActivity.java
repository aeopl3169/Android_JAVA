package com.shiva.a92listviewusinglayoutinflateroptimization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] title;
    String[] description;
    int[] images = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_6, R.drawable.img_7, R.drawable.img_8, R.drawable.img_9, R.drawable.img_10, R.drawable.img_11, R.drawable.img_12};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resources = getResources();
        title = resources.getStringArray(R.array.titles);
        description = resources.getStringArray(R.array.descriptions);
        ListView listView = (ListView)findViewById(R.id.listView);
        ClassAdapter classAdapter = new ClassAdapter(this,title,images,description);
        listView.setAdapter(classAdapter);
    }
}

class ClassAdapter extends ArrayAdapter<String>{
    Context context;
    String[] titles;
    String[] description;
    int[] images;

    ClassAdapter(Context context, String[] titles, int[] images, String[] description){
//        super(context,R.layout.single_row,R.id.textViewDescription, Collections.singletonList(description));
        super(context,R.layout.single_row, R.id.textViewTitles, titles);
        this.context = context;
        this.titles = titles;
        this.description = description;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Object recycling
        //Optimizing(150%) the ListView by reusing the layout inflater from creating object. Here we are reusing the row object.
        View view = convertView;
        ViewHolder viewHolder;
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.single_row, parent,false);
            viewHolder = new ViewHolder(view);
            // Storing the created object by "setTag" method.
            view.setTag(viewHolder);
            Log.w("OBJ","Creating the object.");
        }
        else {
            // Retrieving the created object by "getTag" method.
            viewHolder = (ViewHolder)view.getTag();
            Log.w("OBJ","Recycling the object.");
        }
        viewHolder.textViewTitles.setText(titles[position]);
        viewHolder.textViewDescription.setText(description[position]);
        viewHolder.imageView.setImageResource(images[position]);
        return view;
    }

    class ViewHolder {
        TextView textViewTitles, textViewDescription;
        ImageView imageView;
        ViewHolder(View view){
            textViewTitles = (TextView)view.findViewById(R.id.textViewTitles);
            textViewDescription = (TextView)view.findViewById(R.id.textViewDescription);
            imageView = (ImageView)view.findViewById(R.id.imageView);
        }
    }
}