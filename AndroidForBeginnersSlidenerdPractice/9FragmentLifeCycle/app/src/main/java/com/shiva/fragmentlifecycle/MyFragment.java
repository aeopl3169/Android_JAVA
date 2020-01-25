package com.shiva.fragmentlifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("ACTIVITY","onAttach fragment called.");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ACTIVITY","onCreate fragment called.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("ACTIVITY","onCreateView fragment called.");
        return inflater.inflate(R.layout.my_fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("ACTIVITY","onActivityCreated fragment called.");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("ACTIVITY","onViewStateRestored fragment called.");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("ACTIVITY","onStart fragment called.");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("ACTIVITY","onResume fragment called.");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("ACTIVITY","onPause fragment called.");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("ACTIVITY","onStop fragment called.");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("ACTIVITY","onSaveInstanceState fragment called.");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("ACTIVITY","onDestroyView fragment called.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ACTIVITY","onDestroy fragment called.");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("ACTIVITY","onDetach fragment called.");
    }
}