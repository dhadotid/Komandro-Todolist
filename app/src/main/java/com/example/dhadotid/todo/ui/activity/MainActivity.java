package com.example.dhadotid.todo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dhadotid.todo.R;
import com.example.dhadotid.todo.base.BaseApplicationActivity;
import com.example.dhadotid.todo.ui.activity.controller.MainController;

import butterknife.ButterKnife;

public class MainActivity extends BaseApplicationActivity {

    MainController mainController;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initItem() {
        ButterKnife.bind(this);
        mainController = new MainController(this);
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//    }
}
