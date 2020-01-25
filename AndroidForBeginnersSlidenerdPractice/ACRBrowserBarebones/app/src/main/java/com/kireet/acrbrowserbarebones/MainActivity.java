package com.kireet.acrbrowserbarebones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentC fragmentC;
    FragmentD fragmentD;
    FragmentG fragmentG;
    FragmentE fragmentE;
    FragmentH fragmentH;
    FragmentI fragmentI;
    FragmentJ fragmentJ;
    FragmentK fragmentK;
    FragmentL fragmentL;
    FragmentM fragmentM;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentC = new FragmentC();
        fragmentG = new FragmentG();
        fragmentD = new FragmentD();
        fragmentE = new FragmentE();
        fragmentH = new FragmentH();
        fragmentI = new FragmentI();
        fragmentJ = new FragmentJ();
        fragmentK = new FragmentK();
        fragmentL = new FragmentL();
        fragmentM = new FragmentM();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.linearLayoutContainer, fragmentC, "C");
        fragmentTransaction.addToBackStack("C_Back");
        fragmentTransaction.commit();
    }

    public void next(View view) {
        if (count <= 0) {
            count = 1;
        }

        switch (count) {
            case 1:
                if (fragmentC != null && fragmentC.isVisible() && count == 1) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.linearLayoutContainer, fragmentD, "D").commit();
                    fragmentTransaction.addToBackStack("D_Back");
                    count++;
                } else {
//                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
                }
                break;
            case 2:
                if (fragmentD != null && fragmentD.isVisible() && count == 2) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.linearLayoutContainer, fragmentG, "G").commit();
                    fragmentTransaction.addToBackStack("G_Back");
                    count++;
                } else {
//                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
                }
                break;
            case 3:
                if (fragmentG != null && fragmentG.isVisible() && count == 3) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.linearLayoutContainer, fragmentE, "E").commit();
                    fragmentTransaction.addToBackStack("E_Back");
                    count++;
                } else {
//                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
                }
                break;
            case 4:
                if (fragmentE != null && fragmentE.isVisible() && count == 4) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.linearLayoutContainer, fragmentH, "H").commit();
                    fragmentTransaction.addToBackStack("H_Back");
                    count++;
                } else {
//                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
                }
                break;
            case 5:
                if (fragmentH != null && fragmentH.isVisible() && count == 5) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.linearLayoutContainer, fragmentI, "I").commit();
                    fragmentTransaction.addToBackStack("I_Back");
                    count++;
                } else {
//                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
                }
                break;
            case 6:
                if (fragmentI != null && fragmentI.isVisible() && count == 6) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.linearLayoutContainer, fragmentJ, "J").commit();
                    fragmentTransaction.addToBackStack("J_Back");
                    count++;
                } else {
//                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
                }
                break;
            case 7:
                if (fragmentJ != null && fragmentJ.isVisible() && count == 7) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.linearLayoutContainer, fragmentK, "K").commit();
                    fragmentTransaction.addToBackStack("K_Back");
                    count++;
                } else {
//                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
                }
            case 8:
                if (fragmentK != null && fragmentK.isVisible() && count == 8) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.linearLayoutContainer, fragmentL, "L").commit();
                    fragmentTransaction.addToBackStack("L_Back");
                    count++;
                } else {
//                    Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
                }
            case 9:
                if (fragmentL != null && fragmentL.isVisible() && count == 9) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.linearLayoutContainer, fragmentM, "M").commit();
                    fragmentTransaction.addToBackStack("M_Back");
                    Toast.makeText(this, "FINISH", Toast.LENGTH_LONG).show();
                    count++;
                } else {
//
                }
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        count--;
        return super.onKeyDown(keyCode, event);
    }
}