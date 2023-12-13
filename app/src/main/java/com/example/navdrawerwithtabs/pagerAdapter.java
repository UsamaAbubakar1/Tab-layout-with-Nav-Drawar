package com.example.navdrawerwithtabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class pagerAdapter extends FragmentPagerAdapter {

    public pagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new chat();

        } else if (position == 1) {
            return new status();
        } else
            return new call();
    }

    @Override
    public int getCount() {
        return 3;


    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Chat";
        }else if (position ==1){
            return "Status";
        }else
            return "Call";
    }
}
