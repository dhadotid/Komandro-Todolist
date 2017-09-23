package com.example.dhadotid.todo.ui.fragment.controller;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.example.dhadotid.todo.adapter.TodoListAdapter;
import com.example.dhadotid.todo.connection.TodoListRequest;
import com.example.dhadotid.todo.connection.listener.RequestAllDataListener;
import com.example.dhadotid.todo.model.TodoListModel;
import com.example.dhadotid.todo.ui.fragment.ListFragment;

import java.util.ArrayList;

/**
 * Created by dhadotid on 22/09/2017.
 */

public class ListFragmentController {
    ListFragment listFragment;
    ArrayList<TodoListModel> todolist = new ArrayList<>();
    TodoListAdapter todoListAdapter;

    public ListFragmentController(ListFragment listFragment){
        this.listFragment = listFragment;
        requestData();
    }
    private void initRecycleView(){
        todoListAdapter = new TodoListAdapter(listFragment.getContext(), todolist);

        listFragment.getRecyclerView().setItemAnimator(new DefaultItemAnimator());
        listFragment.getRecyclerView().setLayoutManager(new LinearLayoutManager(listFragment.getActivity()));
        listFragment.getRecyclerView().setAdapter(todoListAdapter);
    }
    private void requestData(){
        new TodoListRequest(listFragment.getContext()).requestAllData(new RequestAllDataListener() {
            @Override
            public void onDataSetResult(ArrayList<TodoListModel> response) {
                todolist = response;
                initRecycleView();
            }

            @Override
            public void onDataIsEmpty() {
                listFragment.showToast("Data Kosong");
            }

            @Override
            public void onRequestError(String errorMessage) {
                listFragment.showToast(errorMessage);
            }
        });
    }
}
