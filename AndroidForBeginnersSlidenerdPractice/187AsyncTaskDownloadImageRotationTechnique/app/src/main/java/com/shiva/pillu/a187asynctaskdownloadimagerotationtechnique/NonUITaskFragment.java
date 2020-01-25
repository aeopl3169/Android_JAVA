package com.shiva.pillu.a187asynctaskdownloadimagerotationtechnique;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NonUITaskFragment extends Fragment {

    Context context;
    AsyncTaskDownload asyncTaskDownload = null;

    public NonUITaskFragment(Context context) {
        this.context = context;
    }

    public void beginTaskMethod(String... arguments) {
        asyncTaskDownload = new AsyncTaskDownload (context);
        asyncTaskDownload.execute (arguments);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach (context);
        Log.d ("ASYNC", "onAttach Fragment");
        this.context = context;
        if (asyncTaskDownload != null) {
            asyncTaskDownload.onAttachMethod (context);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        Log.d ("ASYNC", "onActivityCreated Fragment");
        // setRetainInstance method will prevent from destroying the fragment.
        setRetainInstance (true);
    }

    @Override
    public void onDetach() {
        super.onDetach ();
        Log.d ("ASYNC", "onDetach Fragment");
        if (asyncTaskDownload != null) {
            asyncTaskDownload.onDetachMethod ();
        }
    }

/*
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        Log.d ("ASYNC", "onCreate Fragment");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d ("ASYNC", "onCreateView Fragment");
        return super.onCreateView (inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart ();
        Log.d ("ASYNC", "onStart Fragment");
    }

    @Override
    public void onResume() {
        super.onResume ();
        Log.d ("ASYNC", "onResume Fragment");
    }

    @Override
    public void onPause() {
        super.onPause ();
        Log.d ("ASYNC", "onPause Fragment");
    }

    @Override
    public void onStop() {
        super.onStop ();
        Log.d ("ASYNC", "onStop Fragment");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState (outState);
        Log.d ("ASYNC", "onSvaeInstanceState Fragment");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored (savedInstanceState);
        Log.d ("ASYNC", "onViewStateRestored Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        Log.d ("ASYNC", "onDestroyView Fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy ();
        Log.d ("ASYNC", "onDestroy Fragment");
    }*/
}