package com.example.mvvm_recycler_suggested_retrofit.remote.user;

import com.example.mvvm_recycler_suggested_retrofit.model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UsersList {


    @SerializedName("data")
    @Expose
    private ArrayList<User> arrayList = new ArrayList<>();

    public ArrayList<User> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<User> arrayList) {
        this.arrayList = arrayList;
    }
}
