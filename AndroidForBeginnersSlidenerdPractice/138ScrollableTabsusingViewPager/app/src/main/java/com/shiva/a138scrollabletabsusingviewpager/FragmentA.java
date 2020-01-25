package com.shiva.a138scrollabletabsusingviewpager;

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
        Log.d("FRAGMENT", "Fragment-A onAttach method.");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FRAGMENT", "Fragment-A onCreate method.");
        if(savedInstanceState == null){
            Log.d("FRAGMENT", "Fragment-A onCreate called first time.");
        } else {
            Log.d("FRAGMENT", "Fragment-A onCreate called subsequent time.");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.d("FRAGMENT", "Fragment-A onCreateView method.");
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("FRAGMENT", "Fragment-A onActivityCreated method.");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("FRAGMENT", "Fragment-A onViewStateRestored method.");
        if(savedInstanceState == null){
            Log.d("FRAGMENT", "Fragment-A onViewStateRestored called first time.");
        } else {
            Log.d("FRAGMENT", "Fragment-A onViewStateRestored called subsequent time.");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("FRAGMENT", "Fragment-A onStart method.");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FRAGMENT", "Fragment-A onResume method.");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("FRAGMENT", "Fragment-A onSaveInstanceState method.");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("FRAGMENT", "Fragment-A onPause method.");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("FRAGMENT", "Fragment-A onStop method.");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("FRAGMENT", "Fragment-A onDestroyView method.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("FRAGMENT", "Fragment-A onDestroy method.");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("FRAGMENT", "Fragment-A onDetach method.");
    }
}
