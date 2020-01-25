package com.shiva.pillu.headlinessample;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentTOI extends Fragment implements Communicator {
    ListView listView;
    MyAsyncTask myAsyncTask;
    Context context;
    ArrayAdapter<String> arrayAdapter;
    Communicator communicator;
    ArrayList<HashMap<String, String>> results;
    MyBaseAdapter myBaseAdapter;

    public FragmentTOI(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView (inflater, container, savedInstanceState);
        View view = inflater.inflate (R.layout.fragment_toi, container, false);
        listView = view.findViewById (R.id.list_view_toi);
        startTask ();
//        MyArrayAdapter myArrayAdapter = new MyArrayAdapter (getActivity (),R.layout.single_row ,results);
//        listView.setAdapter (myArrayAdapter);
//        myBaseAdapter = new MyBaseAdapter (getActivity (), results);
//        listView.setAdapter (myBaseAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
    }

    // Method to start the AsyncTask with new one if null.
    public void startTask() {
        //if the download is empty then cancel, else start the task
        if (myAsyncTask != null) {
            myAsyncTask.cancel (true);
        } else {
            myAsyncTask = new MyAsyncTask (getActivity ());
            myAsyncTask.execute ();
        }
    }

    // Method to receive data from onPostExecute of AsyncTask.
    public void receiveData(ArrayList<HashMap<String, String>> results) {

        Log.d ("XML", "FragmentTOI receiveData Method: " + results);
        this.results = results;
        myBaseAdapter = new MyBaseAdapter (context, results);
        listView.setAdapter (myBaseAdapter);
    }


    @Override
    public void receiveInfo(ArrayList<HashMap<String, String>> results) {
//        myBaseAdapter.send (results);
    }
}