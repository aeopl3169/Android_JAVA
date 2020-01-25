package com.shiva.pillu.headlines;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    AdapterPagerClass adapterPagerClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        viewPager = findViewById (R.id.view_pager);
        tabLayout = findViewById (R.id.tab_layout);

        adapterPagerClass =  new AdapterPagerClass (this, getSupportFragmentManager (), tabLayout.getTabCount ());
        viewPager.setAdapter (adapterPagerClass);
        tabLayout.setupWithViewPager (viewPager);
    }
}
