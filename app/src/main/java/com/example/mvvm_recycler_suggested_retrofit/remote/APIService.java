package com.example.mvvm_recycler_suggested_retrofit.remote;

import com.example.mvvm_recycler_suggested_retrofit.remote.user.UsersList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    @GET("/mvvm.php")
    Call<UsersList> getUsersList(@Query("name") String name);

    @FormUrlEncoded
    @POST("/mvvm.php")
    Call<UsersList> getUsersListByPostRequest (@Field("name") String name);


}
