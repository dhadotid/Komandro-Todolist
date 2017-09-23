package com.example.dhadotid.todo.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.dhadotid.todo.R;
import com.example.dhadotid.todo.model.TodoListModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dhadotid on 22/09/2017.
 */

public class TodoListViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.custom_layout_todolist_namatask)TextView namatask;
    @BindView(R.id.custom_layout_todolist_tanggaldeadline)TextView tanggaldeadline;
    @BindView(R.id.custom_layout_todolist_tanggaldibuat)TextView tanggaldibuat;

    public TodoListViewHolder(View view){
        super(view);
        ButterKnife.bind(this, view);
    }
    public void bindDataToUI(TodoListModel todoListModel){
        namatask.setText(todoListModel.getNamaTask());
        tanggaldeadline.setText(getTanggal(todoListModel.getTanggalDeadline()));
        tanggaldibuat.setText(getTanggal(todoListModel.getTanggalDibikin()));
    }
    private String getTanggal(long tanggal){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.US);
        return simpleDateFormat.format(new Date(tanggal));
    }
}
