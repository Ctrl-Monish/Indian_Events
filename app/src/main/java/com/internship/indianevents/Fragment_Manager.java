package com.internship.indianevents;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Fragment_Manager extends FragmentPagerAdapter {

    private int tabno;

    public Fragment_Manager(@NonNull FragmentManager fm, int behavior, int tabno) {
        super(fm, behavior);
        this.tabno = tabno;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0: return new Events_Fragment();
            case 1: return new Births_Fragment();
            case 2: return new Deaths_Fragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabno;
    }
}
