package com.example.dhadotid.todo.ui.activity.controller;

import android.graphics.drawable.Drawable;

import com.example.dhadotid.todo.R;
import com.example.dhadotid.todo.adapter.ViewPagerAdapter;
import com.example.dhadotid.todo.ui.activity.SecondActivity;

import butterknife.BindDrawable;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dhadotid on 22/09/2017.
 */

public class SecondController {
    SecondActivity secondActivity;
    @BindDrawable(R.drawable.todo)Drawable iconTodo;
    @BindDrawable(R.drawable.finish)Drawable iconFinish;

    public SecondController(SecondActivity secondActivity){
        this.secondActivity = secondActivity;
        ButterKnife.bind(this, secondActivity);
        initViewPager();
        initTabLayout();
    }

    private void initViewPager(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(secondActivity.getSupportFragmentManager());
        secondActivity.getViewPager().setAdapter(adapter);
    }
    private void initTabLayout(){
        secondActivity.getTabLayout().setupWithViewPager(secondActivity.getViewPager());
        secondActivity.getTabLayout().removeAllTabs();
        secondActivity.getTabLayout().addTab(secondActivity.getTabLayout().newTab().setIcon(iconTodo));
        secondActivity.getTabLayout().addTab(secondActivity.getTabLayout().newTab().setIcon(iconFinish));
    }
    @OnClick(R.id.activity_second_floatingadd)
    public void onFabClicked(){

    }
}
