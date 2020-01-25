package com.shiva.a101listviewusingbaseadapteroptimization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        if (intent != null) {
            String str = intent.getStringExtra("titles");
            int img = intent.getIntExtra("image", R.drawable.img_1);

            imageView.setImageResource(img);
            textView.setText(str);
        }
    }

    public void closeMethod(View view) {
        finish();
    }
}
