package com.shiva.pillu.headlines;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NonUIFragment extends Fragment {

    ResultsCallBackInterface resultsCallBackInterface;
    MyAsyncTask myAsyncTask;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach (context);
        resultsCallBackInterface = (ResultsCallBackInterface) context;
        if (myAsyncTask != null){
            myAsyncTask.onAttachMethod (resultsCallBackInterface);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        // By calling setRetainInstance the fragment will not destroy.
        setRetainInstance (true);
    }

    @Override
    public void onDetach() {
        super.onDetach ();
        resultsCallBackInterface = null;
        if (myAsyncTask != null){
            myAsyncTask.onDetachMethod ();
        }
    }

    public void startAsyncTask(){
        if (myAsyncTask !=null){
            myAsyncTask.cancel (true);
        } else {
            myAsyncTask = new MyAsyncTask (resultsCallBackInterface);
            myAsyncTask.execute ();
        }
    }
}
