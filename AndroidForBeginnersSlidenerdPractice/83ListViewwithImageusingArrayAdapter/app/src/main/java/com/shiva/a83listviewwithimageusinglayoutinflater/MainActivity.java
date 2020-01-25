package com.shiva.a83listviewwithimageusinglayoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] days = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
//    String[] days2 = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.single_row,R.id.textView,days);
//        ArrayAdapter<String> stringArrayAdapter2 = new ArrayAdapter<String>(this, R.layout.single_row,R.id.textView2,days2);
        listView.setAdapter(stringArrayAdapter);
    }
}
