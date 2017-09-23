package com.example.dhadotid.todo.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.example.dhadotid.todo.R;
import com.example.dhadotid.todo.base.BaseApplicationFragment;
import com.example.dhadotid.todo.ui.fragment.controller.ListFragmentController;

import butterknife.BindView;

/**
 * Created by dhadotid on 22/09/2017.
 */

public class ListFragment extends BaseApplicationFragment {
    @BindView(R.id.fragment_list_recycleview)RecyclerView recyclerView;
    ListFragmentController listFragmentController;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_list;
    }

    @Override
    public void initDate() {
        listFragmentController = new ListFragmentController(this);
    }
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
