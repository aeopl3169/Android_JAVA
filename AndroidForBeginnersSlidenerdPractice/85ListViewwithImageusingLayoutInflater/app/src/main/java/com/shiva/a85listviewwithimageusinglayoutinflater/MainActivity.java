package com.shiva.a85listviewwithimageusinglayoutinflater;

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

    String[] titles;
    String[] description;
    int[] images = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_6, R.drawable.img_7, R.drawable.img_8, R.drawable.img_9, R.drawable.img_10, R.drawable.img_11, R.drawable.img_12};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        titles = resources.getStringArray(R.array.titles);
        description = getResources().getStringArray(R.array.descriptions);

        listView = (ListView) findViewById(R.id.listView);

        ClassAdapter classAdapter = new ClassAdapter(this, titles, images, description);
        listView.setAdapter(classAdapter);
    }
}

class ClassAdapter extends ArrayAdapter<String> {
    Context context;
    String[] stringArrayTitle;
    String[] stringArrayDescription;
    int[] arrayImage;

    ClassAdapter(Context context, String[] titles, int[] images, String[] description) {
        super(context, R.layout.single_row, R.id.textViewTitles, titles);
        this.context = context;
        this.stringArrayTitle = titles;
        this.stringArrayDescription = description;
        this.arrayImage = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Object recycling
        //Optimizing(150%) the ListView by reusing the layout inflater from creating object. Here we are reusing the row object.
        View view = convertView;
        Log.w("INF","Text : "+stringArrayTitle[position]);

        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.single_row, parent, false);
        }
        else{
            System.out.println(view.getId());
        }

//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.single_row, parent, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView textViewTitle = (TextView) view.findViewById(R.id.textViewTitles);
        TextView textViewDescription = (TextView) view.findViewById(R.id.textViewDescription);

        try{
            textViewTitle.setText(stringArrayTitle[position]);
            textViewDescription.setText(stringArrayDescription[position]);
            imageView.setImageResource(arrayImage[position]);

        }
        catch (ArrayIndexOutOfBoundsException e){

        }
//        return super.getView(position, convertView, parent);
        return view;
    }
}