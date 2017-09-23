package com.example.dhadotid.todo.connection.listener;

/**
 * Created by dhadotid on 22/09/2017.
 */

public interface PostTaskListener {
    public void onPostSuccess(int id);
    public void onPostFail();
    public void onRequestError(String errorMessage);
}
