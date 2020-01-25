package com.shiva.a138scrollabletabsusingviewpager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager ();
        ViewPager viewPager = findViewById (R.id.viewPager);
        viewPager.setAdapter (new MyAdapterClass (fragmentManager));

        tabLayout = findViewById (R.id.tabLayout);
        tabLayout.setupWithViewPager (viewPager);
    }

    class MyAdapterClass extends FragmentStatePagerAdapter {

        public MyAdapterClass(FragmentManager fm) {
            super (fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.d ("ViewPager", "getItem method called at" + position);
            Fragment fragment = null;
            if (position == 0) {
                fragment = new FragmentA ();
            } else if (position == 1) {
                fragment = new FragmentB ();
            } else if (position == 2) {
                fragment = new FragmentC ();
            } else if (position == 3) {
                fragment = new FragmentD ();
            } else if (position == 4) {
                fragment = new FragmentA ();
            } else if (position == 5) {
                fragment = new FragmentB ();
            } else if (position == 6) {
                fragment = new FragmentC ();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            Log.d ("ViewPager", "getCount method called.");
            return 7;
        }

        int[] imageResId = {
                R.drawable.toi,
                R.drawable.toi,
                R.drawable.toi};

        // This method returns the page title in the tabs.
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            Log.d ("ViewPager", "getPageTitle method called at " + position);
            super.getPageTitle (position);
            String tabString = null;
            if (position == 0) {
                tabString = "TAB line is big 1. ok this is to test the tool is it working or not.";
            } else if (position == 1) {
                tabString = "TAB 2";
            } else if (position == 2) {
                tabString = "TAB 3";
            } else if (position == 3) {
                tabString = "TAB 4";
            } else if (position == 4) {
                tabString = "TAB 4";
            } else if (position == 5) {
                tabString = "TAB 4";
            } else if (position == 6) {
                tabString = "TAB 4";
            } else if (position == 7) {
                tabString = "TAB 4";
            }
            return tabString;
        }
    }
}