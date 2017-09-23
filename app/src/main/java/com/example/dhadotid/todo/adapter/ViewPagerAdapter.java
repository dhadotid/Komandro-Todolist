package com.example.dhadotid.todo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import com.example.dhadotid.todo.ui.fragment.FinishFragment;


/**
 * Created by dhadotid on 22/09/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : {
                return new ListFragment();
            }
            case 1 : {
                return new FinishFragment();
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
