package com.example.dhadotid.todo.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.example.dhadotid.todo.R;
import com.example.dhadotid.todo.base.BaseApplicationFragment;
import com.example.dhadotid.todo.ui.fragment.controller.FinishFragmentController;

import butterknife.BindView;

/**
 * Created by dhadotid on 23/09/2017.
 */

public class FinishFragment extends BaseApplicationFragment {
    FinishFragmentController finishFragmentController;
    @BindView(R.id.fragment_finish_recycleview)RecyclerView recyclerView;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_finish;
    }

    @Override
    public void initDate() {
        finishFragmentController = new FinishFragmentController(this);
    }
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
