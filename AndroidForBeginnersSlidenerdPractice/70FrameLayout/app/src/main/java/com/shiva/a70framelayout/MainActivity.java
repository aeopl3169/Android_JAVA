package com.shiva.a70framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.image);
        imageView2 = (ImageView) findViewById(R.id.image2);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener((View.OnClickListener) this);
//        imageView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.image) {
            imageView1.setVisibility(View.GONE);
            imageView2.setVisibility(View.VISIBLE);
        } else {
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.GONE);
        }
    }
}
