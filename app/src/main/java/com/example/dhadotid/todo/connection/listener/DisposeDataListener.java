package com.example.dhadotid.todo.connection.listener;

/**
 * Created by dhadotid on 22/09/2017.
 */

public interface DisposeDataListener {
    public void onDisposeDataSuccess();
    public void onDisposeDataFailed();
    public void onRequestError(String errorMessage);
}
