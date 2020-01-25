package com.shiva.a1241portraitonefragmentlandtwofragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment implements AdapterView.OnItemClickListener {
    ListView listView;
    Communicator communicator;
    ArrayAdapter arrayAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        listView = (ListView)view.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
//        communicator = (Communicator)getActivity();
        arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.titles, android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        communicator.respond(i);
    }

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    public interface Communicator {
        public void respond(int data);
    }
}