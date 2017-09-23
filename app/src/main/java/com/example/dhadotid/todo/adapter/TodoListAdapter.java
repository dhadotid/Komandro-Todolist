package com.example.dhadotid.todo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dhadotid.todo.R;
import com.example.dhadotid.todo.adapter.viewholder.TodoListViewHolder;
import com.example.dhadotid.todo.model.TodoListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhadotid on 22/09/2017.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListViewHolder>{
    Context context;
    List<TodoListModel> todoListModels = new ArrayList<>();

    public TodoListAdapter(Context context, List<TodoListModel> todoListModels){
        this.context = context;
        this.todoListModels = todoListModels;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public TodoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_layout_todolist, null);
        return new TodoListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TodoListViewHolder holder, int position) {
        TodoListModel model = todoListModels.get(position);
        holder.bindDataToUI(model);
    }

    @Override
    public int getItemCount() {
        return todoListModels.size();
    }
}
