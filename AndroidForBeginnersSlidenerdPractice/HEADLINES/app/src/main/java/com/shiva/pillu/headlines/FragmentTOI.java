package com.shiva.pillu.headlines;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentTOI extends Fragment implements ResultsCallBackInterface {

    ListView listView;
    FragmentHolder fragmentHolder;


    public FragmentTOI() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView (inflater, container, savedInstanceState);
        View view = inflater.inflate (R.layout.fragment_toi, container, false);
        listView = view.findViewById (R.id.list_view_toi);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        if (savedInstanceState == null) {
            fragmentHolder = new FragmentHolder (getActivity ());
            getFragmentManager ().beginTransaction ().add (fragmentHolder, "MyFrag").commit ();
        } else {
            fragmentHolder = (FragmentHolder) getFragmentManager ().findFragmentByTag ("MyFrag");
        }
        fragmentHolder.startTask ();
    }

    @Override
    public void onPreExecuteInterface() {
    }

    @Override
    public void onPostExecuteInterface(ArrayList<HashMap<String, String>> results) {
        Log.d ("XML", "FragmentTOI: " + results);
//        listView.setAdapter ((ListAdapter) results);
    }

    public void receive(ArrayList<HashMap<String, String>> results){
        Log.d ("XML", "FragmentTOI receive: " + results);
        listView.setAdapter (new MyBaseAdapter (getActivity ().getApplicationContext (), results));
    }

    public static class FragmentHolder extends Fragment {
        ResultsCallBackInterface resultsCallBackInterface;
        MyAsyncTask myAsyncTask;
        Context context;

        public FragmentHolder(ResultsCallBackInterface resultsCallBackInterface) {
            this.resultsCallBackInterface = resultsCallBackInterface;
        }

        public FragmentHolder(Context context) {
           this.context = context;
        }

        @Override
        public void onAttach(@NonNull Context context) {
            super.onAttach (context);
//            resultsCallBackInterface = (ResultsCallBackInterface) context;
            if (myAsyncTask != null) {
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
            if (myAsyncTask != null) {
                myAsyncTask.onDetachMethod ();
            }
        }

        // Method to start the AsyncTask with new one if null or...
        public void startTask() {
            //if the download is empty then cancel, else start the task
            if (myAsyncTask != null) {
                myAsyncTask.cancel (true);
            } else {
//                myAsyncTask = new MyAsyncTask (resultsCallBackInterface);
                myAsyncTask = new MyAsyncTask (context);
                myAsyncTask.execute ();
            }
        }
    }
}