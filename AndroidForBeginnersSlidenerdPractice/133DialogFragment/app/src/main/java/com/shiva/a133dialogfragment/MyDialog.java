package com.shiva.a133dialogfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment implements View.OnClickListener {
    Button buttonYes, buttonNo;
    Communicator communicator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_dialog, null);
        buttonYes = (Button) view.findViewById(R.id.buttonYesId);
        buttonNo = (Button) view.findViewById(R.id.buttonNoId);
        communicator = (Communicator) getActivity();
//        setShowsDialog(false);
        // Dialog will not cancel if (the user touches outside the dialog) setCancelable is set to false.
        setCancelable(false);
        buttonYes.setOnClickListener(this);
        buttonNo.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonYesId) {
            communicator.dialogCommunicate(buttonYes.getText().toString());
            dismiss();
        } else if (view.getId() == R.id.buttonNoId) {
            communicator.dialogCommunicate(buttonNo.getText().toString());
            dismiss();
        }
    }
}

interface Communicator {
    public void dialogCommunicate(String message);
}