package com.shiva.a126fragmenttransactionaddremovereplace;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.w("FRAGMENT","onAttach method called.");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w("FRAGMENT","onCreate method called.");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.w("FRAGMENT","onCreateView method called.");
        return inflater.inflate(R.layout.fragment_a, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.w("FRAGMENT","onActivityCreated method called.");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.w("FRAGMENT","onStart method called.");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.w("FRAGMENT","onResume method called.");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.w("FRAGMENT","onPause method called.");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.w("FRAGMENT","onStop method called.");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.w("FRAGMENT","onDestroyView method called.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w("FRAGMENT","onDestroy method called.");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.w("FRAGMENT","onDetach method called.");
    }
}