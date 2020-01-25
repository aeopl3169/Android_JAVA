package com.shiva.a121fragmentcommviainterfacesaveinstancest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment implements View.OnClickListener{
    CommunicatorInterface communicatorInterface;
    int count = 0;
    Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (savedInstanceState == null){
            count = 0;
        } else {
            count = savedInstanceState.getInt("countSave");
//            count = savedInstanceState.getInt("countSave",0);
        }
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicatorInterface = (CommunicatorInterface)getActivity();
        button = (Button)getActivity().findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        count++;
        communicatorInterface.passValue(count+" time clicked.");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countSave",count);
    }
}
