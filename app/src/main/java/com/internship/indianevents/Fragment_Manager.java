package com.internship.indianevents;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class Fragment_Manager extends FragmentStateAdapter {


    public Fragment_Manager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public Fragment_Manager(@NonNull Fragment fragment) {
        super(fragment);
    }

    public Fragment_Manager(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
                return new Events_Fragment();
            case 1:
                return new Births_Fragment();
            case 2:
                return new Deaths_Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
