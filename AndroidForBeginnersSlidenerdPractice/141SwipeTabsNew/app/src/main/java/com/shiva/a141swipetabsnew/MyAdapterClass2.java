package com.shiva.a141swipetabsnew;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyAdapterClass2 extends FragmentStatePagerAdapter {

    private String[] tabTitles = new String[]{"TAB 1", "TAB 2", "TAB 3", "TAB 4", "TAB 5"};

    public MyAdapterClass2(MainActivity mainActivity, FragmentManager fm, int tabCount) {
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
