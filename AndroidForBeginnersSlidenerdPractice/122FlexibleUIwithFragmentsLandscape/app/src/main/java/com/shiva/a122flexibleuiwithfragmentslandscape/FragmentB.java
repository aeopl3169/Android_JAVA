package com.shiva.a122flexibleuiwithfragmentslandscape;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentB extends Fragment {
    TextView textView;
    int value;
    String[] description;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = (TextView) getActivity().findViewById(R.id.textView);
        description = getResources().getStringArray(R.array.description);
        if (savedInstanceState == null) {

        } else {
            int local = savedInstanceState.getInt("saveString");
            textView.setText(description[local]);
        }
    }

    public void mehotdSetText(int val) {
        textView.setText(description[val]);
        this.value = val;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("saveString", value);
    }
}