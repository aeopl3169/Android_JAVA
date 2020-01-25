package com.shiva.a141swipetabs;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    ActionBar actionBar = null;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyAdapterClass(getSupportFragmentManager()));
        // This listener notifies when swiping from sibling fragments.
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("TAB", "onPageScrolled called at position: " + position + " , position off set float : " + positionOffset + " , position off set pixels: " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                // The onPageSelected gives the which fragment (position) is selected.
                actionBar.setSelectedNavigationItem(position);
                Log.d("TAB", "onPageSelected called at position " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("TAB", "onPageScrollStateChanged called at position" + state);
            }
        });

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionBar.newTab();
        tab1.setText("TAB 1");
        tab1.setTabListener(this);

        ActionBar.Tab tab2 = actionBar.newTab();
        tab2.setText("TAB 2");
        tab2.setTabListener(this);

        ActionBar.Tab tab3 = actionBar.newTab();
        tab3.setText("TAB 3");
        tab3.setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.d("TAB", "onTabSelected called at position" + tab.getPosition() + " ,name of the tab: " + tab.getText());
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {
        Log.d("TAB", "onTabUnSelected called at position" + tab.getPosition() + " ,name of the tab: " + tab.getText());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {
        Log.d("TAB", "onTabReselected called at position" + tab.getPosition() + " ,name of the tab: " + tab.getText());

    }
}

class MyAdapterClass extends FragmentPagerAdapter {

    public MyAdapterClass(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new FragmentA();
        } else if (position == 1) {
            fragment = new FragmentB();
        } else if (position == 2) {
            fragment = new FragmentC();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}