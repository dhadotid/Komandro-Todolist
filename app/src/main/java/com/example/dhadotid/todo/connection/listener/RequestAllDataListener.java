package com.example.dhadotid.todo.connection.listener;

import com.example.dhadotid.todo.model.TodoListModel;

import java.util.ArrayList;

/**
 * Created by dhadotid on 22/09/2017.
 */

public interface RequestAllDataListener {
    public void onDataSetResult(ArrayList<TodoListModel> response);
    public void onDataIsEmpty();
    public void onRequestError(String errorMessage);
}
