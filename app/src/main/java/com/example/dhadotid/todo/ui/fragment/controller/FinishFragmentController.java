package com.example.dhadotid.todo.ui.fragment.controller;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.example.dhadotid.todo.adapter.TodoListAdapter;
import com.example.dhadotid.todo.connection.TodoListRequest;
import com.example.dhadotid.todo.connection.listener.RequestAllDataListener;
import com.example.dhadotid.todo.model.TodoListModel;
import com.example.dhadotid.todo.ui.fragment.FinishFragment;

import java.util.ArrayList;

/**
 * Created by dhadotid on 23/09/2017.
 */

public class FinishFragmentController {
    FinishFragment finishFragment;
    ArrayList<TodoListModel> todolist = new ArrayList<>();
    TodoListAdapter todoListAdapter;

    public FinishFragmentController(FinishFragment finishFragment){
        this.finishFragment = finishFragment;
        requestData();
    }

    private void initRecycleView(){
        todoListAdapter = new TodoListAdapter(finishFragment.getContext(), todolist);

        finishFragment.getRecyclerView().setItemAnimator(new DefaultItemAnimator());
        finishFragment.getRecyclerView().setLayoutManager(new LinearLayoutManager(finishFragment.getActivity()));
        finishFragment.getRecyclerView().setAdapter(todoListAdapter);
    }
    private void requestData(){
        new TodoListRequest(finishFragment.getContext()).requestAllData(new RequestAllDataListener() {
            @Override
            public void onDataSetResult(ArrayList<TodoListModel> response) {
                todolist = response;
                initRecycleView();
            }

            @Override
            public void onDataIsEmpty() {
                finishFragment.showToast("Data Kosong");
            }

            @Override
            public void onRequestError(String errorMessage) {
                finishFragment.showToast(errorMessage);
            }
        });
    }
    private void deleteData(){
        finishFragment.getRecyclerView().addOnItemTouchListener();
    }
}
