package com.example.dhadotid.todo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dhadotid on 22/09/2017.
 */

public class TodoListModel implements Parcelable{

    private int id;
    private String namaTask;
    private long tanggalDeadline;
    private long tanggalDibikin;
    private int status;

    public TodoListModel(int id, String namaTask, long tanggalDeadline, long tanggalDibikin, int status){
        this.id = id;
        this.namaTask = namaTask;
        this.tanggalDeadline = tanggalDeadline;
        this.tanggalDibikin = tanggalDibikin;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNamaTask() {
        return namaTask;
    }

    public long getTanggalDeadline() {
        return tanggalDeadline;
    }

    public long getTanggalDibikin() {
        return tanggalDibikin;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.namaTask);
        dest.writeLong(this.tanggalDeadline);
        dest.writeLong(this.tanggalDibikin);
        dest.writeInt(this.status);
    }

    protected TodoListModel(Parcel in) {
        this.id = in.readInt();
        this.namaTask = in.readString();
        this.tanggalDeadline = in.readLong();
        this.tanggalDibikin = in.readLong();
        this.status = in.readInt();
    }

    public static final Creator<TodoListModel> CREATOR = new Parcelable.Creator<TodoListModel>() {
        @Override
        public TodoListModel createFromParcel(Parcel source) {
            return new TodoListModel(source);
        }

        @Override
        public TodoListModel[] newArray(int size) {
            return new TodoListModel[size];
        }
    };
}
