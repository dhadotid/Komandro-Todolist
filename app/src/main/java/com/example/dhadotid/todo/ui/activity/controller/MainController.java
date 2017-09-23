package com.example.dhadotid.todo.ui.activity.controller;

import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;

import com.example.dhadotid.todo.R;
import com.example.dhadotid.todo.ui.activity.MainActivity;
import com.example.dhadotid.todo.ui.activity.SecondActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dhadotid on 22/09/2017.
 */

public class MainController {
    MainActivity mainActivity;
    @BindView(R.id.progressBar)ProgressBar progressBar;



    public MainController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        ButterKnife.bind(this, mainActivity);
        timesplash();
    }

    private void timesplash(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    mainActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(mainActivity, SecondActivity.class);
                            mainActivity.startActivity(intent);
                            mainActivity.finish();
                        }
                    });
                }
            }
        });
        thread.start();
    }
}
