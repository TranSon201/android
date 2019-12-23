package com.example.nhac.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> arrayPragment = new ArrayList<>();
    private ArrayList<String> arraytitle = new ArrayList<>();
    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayPragment.get(position);
    }

    @Override
    public int getCount() {
        return arrayPragment.size();
    }
    public void addPragment(Fragment fragment, String title){
        arrayPragment.add(fragment);
        arraytitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arraytitle.get(position);
    }

}
