package com.shiva.pillu.headlinessample;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AdapterPagerClass extends FragmentStatePagerAdapter {

    private String[] tabTitles = new String[]{"TOI", "TAB 2", "TAB 3"};
    Context context;

    public AdapterPagerClass(Context context, FragmentManager fragmentManager, int behavior) {
        super (fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentTOI (context);
                break;
            case 1:
                fragment = new FragmentTOI (context);
                break;
            case 2:
                fragment = new FragmentTOI (context);
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
        return tabTitles[position];
    }
}