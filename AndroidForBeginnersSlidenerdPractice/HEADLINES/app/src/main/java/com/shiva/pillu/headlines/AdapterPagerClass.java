package com.shiva.pillu.headlines;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AdapterPagerClass extends FragmentStatePagerAdapter {
    private String[] tabTitles = new String[]{"TOI", "TAB 2", "TAB 3", "TAB 4", "TAB 5"};

    public AdapterPagerClass(MainActivity mainActivity, @NonNull FragmentManager fm, int behavior) {
        super (fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentTOI ();
                break;
            case 1:
                fragment = new FragmentTOI ();
                break;
            case 2:
                fragment = new FragmentTOI ();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle (position);
        return tabTitles[position];
    }
}