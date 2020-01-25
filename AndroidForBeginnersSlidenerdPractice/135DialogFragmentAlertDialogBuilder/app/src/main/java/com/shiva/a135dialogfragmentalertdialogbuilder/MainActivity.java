package com.shiva.a135dialogfragmentalertdialogbuilder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
    }

    public void dialogMethod(View view) {
        MyDialog myDialog = new MyDialog();
        myDialog.show(fragmentManager, "mDialog");
    }

    public void listDialogMethod(View view) {
        MyListDialog myListDialog = new MyListDialog();
        myListDialog.show(fragmentManager, "mListDialog");
    }

    public void customDialogMethod(View view) {
        MyCustomDialog myCustomDialog = new MyCustomDialog();
//        myCustomDialog.show(fragmentManager,"mCustomDialog");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.relativeLayoutGroup, myCustomDialog,"mCustomDialog");
        fragmentTransaction.commit();
    }
}
