package com.shiva.a58relativelayoutusingjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    TextView textViewPleaseLogin, textViewUserName, textViewPassword;
    EditText editTextUserName, editTextPassword;
    Button buttonLogin;
    int textViewPleaseLoginID = 1, textViewUserNameID = 2, textViewPasswordID = 3, editTextUserNameID = 4, editTextPasswordID = 5, buttonLoginID = 6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        relativeLayout = new RelativeLayout(this);
        textViewPleaseLogin = new TextView(this);
        textViewUserName = new TextView(this);
        textViewPassword = new TextView(this);
        editTextUserName = new EditText(this);
        editTextPassword = new EditText(this);
        buttonLogin = new Button(this);

        // Root
        LayoutParams layoutParamsRL = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(layoutParamsRL);
        layoutParamsRL.addRule(RelativeLayout.LAYOUT_MODE_CLIP_BOUNDS);

        // Please login
        LayoutParams layoutParamsTextViewPleaseLogin = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        textViewPleaseLogin.setLayoutParams(layoutParamsTextViewPleaseLogin);
        textViewPleaseLogin.setText("Please Login First!");
        textViewPleaseLogin.setPadding(0,50,0,0);
        textViewPleaseLogin.setId(textViewPleaseLoginID);
        layoutParamsTextViewPleaseLogin.addRule(RelativeLayout.CENTER_HORIZONTAL);

        // Text User Name
        LayoutParams layoutParamsTextViewUserName = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textViewUserName.setLayoutParams(layoutParamsTextViewUserName);
        textViewUserName.setText("User Name:");
        textViewUserName.setPadding(20,20,20,20);
        textViewUserName.setId(textViewUserNameID);
        layoutParamsTextViewUserName.addRule(RelativeLayout.BELOW, textViewPleaseLoginID);

        // Text Password
        LayoutParams layoutParamsTextViewPassword = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textViewPassword.setLayoutParams(layoutParamsTextViewPassword);
        textViewPassword.setText("Password:");
        textViewPassword.setPadding(20,20,20,20);
        textViewPassword.setId(textViewPasswordID);
        layoutParamsTextViewPassword.addRule(RelativeLayout.BELOW, textViewUserNameID);
        layoutParamsTextViewPassword.addRule(RelativeLayout.ALIGN_RIGHT, textViewUserNameID);// aligned equal to user name.

        // Edit User Name
        LayoutParams layoutParamsEditTextUserName = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        editTextUserName.setLayoutParams(layoutParamsEditTextUserName);
        editTextUserName.setHint("name");
        editTextUserName.setId(editTextUserNameID);
        layoutParamsEditTextUserName.addRule(RelativeLayout.RIGHT_OF, textViewUserNameID);
        layoutParamsEditTextUserName.addRule(RelativeLayout.ALIGN_BASELINE, textViewUserNameID);
        layoutParamsEditTextUserName.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        // Edit Password
        LayoutParams layoutParamsEditTextPassword = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        editTextPassword.setLayoutParams(layoutParamsEditTextPassword);
        editTextPassword.setHint("password");
        editTextPassword.setId(editTextPasswordID);
        layoutParamsEditTextPassword.addRule(RelativeLayout.RIGHT_OF, textViewPasswordID);
        layoutParamsEditTextPassword.addRule(RelativeLayout.BELOW, editTextUserNameID);
        layoutParamsEditTextPassword.addRule(RelativeLayout.ALIGN_BASELINE, textViewPasswordID);
        layoutParamsEditTextPassword.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        // Button
        LayoutParams layoutParamsButtonLogin = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        buttonLogin.setLayoutParams(layoutParamsButtonLogin);
        buttonLogin.setText("LOGIN");
        buttonLogin.setId(buttonLoginID);
        layoutParamsButtonLogin.addRule(RelativeLayout.CENTER_IN_PARENT);


        relativeLayout.addView(textViewPleaseLogin);
        relativeLayout.addView(textViewUserName);
        relativeLayout.addView(textViewPassword);
        relativeLayout.addView(editTextUserName);
        relativeLayout.addView(editTextPassword);
        relativeLayout.addView(buttonLogin);

        setContentView(relativeLayout);
    }
}
