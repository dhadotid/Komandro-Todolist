package com.example.dhadotid.todo.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.dhadotid.todo.R;
import com.example.dhadotid.todo.base.BaseApplicationActivity;
import com.example.dhadotid.todo.ui.activity.controller.SecondController;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dhadotid on 22/09/2017.
 */

public class SecondActivity extends BaseApplicationActivity{

    @BindView(R.id.activity_secont_tabLayout)TabLayout tabLayout;
    @BindView(R.id.activity_second_viewPager)ViewPager viewPager;
    SecondController secondController;

    @Override
    public int getLayoutID() {
        return R.layout.activity_second;
    }

    @Override
    public void initItem() {
        ButterKnife.bind(this);
        secondController = new SecondController(this);
    }

    public TabLayout getTabLayout() {
        return tabLayout;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }
}
