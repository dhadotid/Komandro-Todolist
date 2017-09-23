package com.example.dhadotid.todo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by dhadotid on 22/09/2017.
 */

public abstract class BaseApplicationFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getLayoutID(), null);
        ButterKnife.bind(this, v);
        initDate();
        return v;
    }

    public void showToast(String message){
        Toast.makeText(getContext(), "" + message, Toast.LENGTH_SHORT).show();
    }
    public abstract int getLayoutID();
    public abstract void initDate();
}
