package com.shiva.a13activityorientation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("CONFIG","On configuration changed: "+newConfig.orientation);

        Log.w("CONFIG","Static field of orientation land scape is: "+Configuration.ORIENTATION_LANDSCAPE);
        Log.w("CONFIG","Static field of orientation portrait is: "+Configuration.ORIENTATION_PORTRAIT);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            Log.i("CONFIG","User is in Landscape mode.");
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            Log.d("CONFIG","User is in Portrait mode.");
        }
    }
}
