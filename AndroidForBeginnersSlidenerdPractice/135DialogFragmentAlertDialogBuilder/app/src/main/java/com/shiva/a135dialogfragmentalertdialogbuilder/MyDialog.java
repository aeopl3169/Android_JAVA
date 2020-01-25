package com.shiva.a135dialogfragmentalertdialogbuilder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("This is Title");
        builder.setMessage("Message to the users");
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "No button clicked", Toast.LENGTH_LONG).show();
                dismiss();
            }
        });
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Yes button clicked", Toast.LENGTH_LONG).show();
            }
        });
        Dialog dialog = builder.create();
        // Dialog will not cancel if (the user touches outside the dialog) setCancelable is set to false.
        setCancelable(false);
        return dialog;
    }
}