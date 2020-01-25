package com.shiva.a141swipetabsnew;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;


import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    MyAdapterClass adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        // Initializing ViewPager, TabLayout and Toolbar
        viewPager = findViewById (R.id.viewPager);
        tabLayout = findViewById (R.id.tabLayout);
        Toolbar toolbar = findViewById (R.id.toolBar);

        //Adding toolbar to the activity and also remove action bar in styles.xml to avoid crash.
        setSupportActionBar (toolbar);

        adapter = new MyAdapterClass (MainActivity.this, getSupportFragmentManager (), tabLayout.getTabCount ());
        viewPager.setAdapter (adapter);
        Log.d ("COUNT", "No. of tabs: " + tabLayout.getTabCount ());
        // setupWithViewPager will attach the tabs with ViewPager.
        tabLayout.setupWithViewPager (viewPager);
        tabLayout.setTabGravity (TabLayout.GRAVITY_FILL);
    }

    class MyAdapterClass extends FragmentStatePagerAdapter {

        private String[] tabTitles = new String[]{"TAB 1", "TAB 2", "TAB 3", "TAB 4", "TAB 5"};

        public MyAdapterClass(MainActivity mainActivity, FragmentManager fm, int tabCount) {
            super (fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position == 0) {
                fragment = new FragmentA ();
            } else if (position == 1) {
                fragment = new FragmentB ();
            } else if (position == 2) {
                fragment = new FragmentC ();
            } else if (position == 3) {
                fragment = new FragmentA ();
            } else if (position == 4) {
                fragment = new FragmentB ();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            super.getPageTitle (position);
            return tabTitles[position];
        }
    }
}