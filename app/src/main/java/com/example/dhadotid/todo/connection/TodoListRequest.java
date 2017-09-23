package com.example.dhadotid.todo.connection;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dhadotid.todo.connection.listener.DisposeDataListener;
import com.example.dhadotid.todo.connection.listener.PostTaskListener;
import com.example.dhadotid.todo.connection.listener.RequestAllDataListener;
import com.example.dhadotid.todo.model.TodoListModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by dhadotid on 22/09/2017.
 */

public class TodoListRequest {
    Context context;
    RequestQueue requestQueue;
    StringRequest stringRequest;

    public TodoListRequest(Context context){
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }
    private void exec(){
        requestQueue.add(stringRequest);
    }
    public void POSTTask(final Map<String, String> params, final PostTaskListener listener){
        stringRequest = new StringRequest(Request.Method.POST, "http://apitodolist.rsypj.com/postdata", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    if (object.getInt("result_code") == 200) {
                        listener.onPostSuccess(object.getInt("id"));
                    } else {
                        listener.onPostFail();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorMessage = "";
                if (error instanceof TimeoutError){
                    errorMessage = "Timeout. Check your connection";
                }else if(error instanceof NoConnectionError){
                    errorMessage = "Please turn on your connection";
                }else if(error instanceof AuthFailureError){
                    errorMessage = "Authentication Error";
                }else if(error instanceof ServerError){
                    errorMessage = "Server Error";
                }else if(error instanceof NetworkError){
                    errorMessage = "Network Error";
                }else if(error instanceof ParseError){
                    errorMessage = "Parse Error";
                }
                listener.onRequestError(errorMessage);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        exec();
    }
    public void requestAllData(final RequestAllDataListener listener){
        final ArrayList<TodoListModel> todoListModels = new ArrayList<>();
        stringRequest = new StringRequest(Request.Method.GET, "http://apitodolist.rsypj.com/getalldata", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    if (array.length() > 0) {
                        for (int a = 0; a < array.length(); a++) {
                            JSONObject object = array.getJSONObject(a);

                            int id = object.getInt("id");
                            String task = object.getString("task");
                            long deadline = object.getLong("deadline");
                            long createdTime = object.getLong("created_time");
                            int status = object.getInt("status");

                            todoListModels.add(new TodoListModel(id, task, deadline, createdTime, status));
                        }
                        listener.onDataSetResult(todoListModels);
                    } else {
                        listener.onDataIsEmpty();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorMessage = "";

                if(error instanceof TimeoutError){
                    errorMessage = "Timeout. Check your connection";
                }else if(error instanceof NoConnectionError){
                    errorMessage = "Please turn or your connection";
                }else if(error instanceof AuthFailureError){
                    errorMessage = "Authentication Error";
                }else if(error instanceof ServerError){
                    errorMessage = "Server Error";
                }else if (error instanceof NetworkError){
                    errorMessage = "Network Error";
                }else if(error instanceof ParseError){
                    errorMessage = "Parse Error";
                }
                listener.onRequestError(errorMessage);
            }
        });
        exec();
    }
    public void deleteData(int id, final DisposeDataListener listener){
        stringRequest = new StringRequest(Request.Method.GET, "http://apitodolist.rsypj.com/getalldata/" + id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    if (object.getInt("result_code") == 200) {
                        listener.onDisposeDataSuccess();
                    } else {
                        listener.onDisposeDataFailed();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorMessage = "";
                if (error instanceof TimeoutError){
                    errorMessage = "Timeout. Check your connection";
                } else if (error instanceof NoConnectionError) {
                    errorMessage = "Please turn on your connectivity";
                } else if (error instanceof AuthFailureError) {
                    errorMessage = "Authentication Error";
                } else if (error instanceof ServerError) {
                    errorMessage = "Server Error";
                } else if (error instanceof NetworkError) {
                    errorMessage = "Network Error";
                } else if (error instanceof ParseError) {
                    errorMessage = "Parse Error";
                }
                listener.onRequestError(errorMessage);
            }
        });
        exec();
    }
}
