package com.shiva.a41linearlayoutusingjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout = new LinearLayout(this);
        textView = new TextView(this);
        button = new Button(this);

        LayoutParams layoutParamsLL = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(layoutParamsLL);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        LayoutParams layoutParamsTB = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);

        textView.setLayoutParams(layoutParamsTB);
        button.setLayoutParams(layoutParamsTB);

        textView.setText("Hello");
        button.setText("Button");

        linearLayout.addView(textView);
        linearLayout.addView(button);

        setContentView(linearLayout);
    }
}