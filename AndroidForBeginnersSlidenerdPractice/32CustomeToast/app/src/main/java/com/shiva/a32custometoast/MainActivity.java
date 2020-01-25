package com.shiva.a32custometoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonMethod(View view) {
        if(view.getId()==R.id.buttonToast){

//        Toast.makeText(this, "This is Toast message.", Toast.LENGTH_SHORT).show();

        Toast toast = Toast.makeText(this,"Toast",Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT,0,0);
//        toast.setGravity(Gravity.HORIZONTAL_GRAVITY_MASK,0,0);
        toast.setGravity(Gravity.TOP,150,150);
        toast.show();
        }

        //Custom Toast
        if (view.getId()==R.id.buttonCustomToast){
            LayoutInflater layoutInflater = getLayoutInflater();
            View appearance = layoutInflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_root));
            Toast toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.CENTER,0,0);
            toast.setView(appearance);
            toast.show();

        }
    }
}
