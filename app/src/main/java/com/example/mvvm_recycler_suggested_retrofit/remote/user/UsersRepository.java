package com.example.mvvm_recycler_suggested_retrofit.remote.user;

import android.arch.lifecycle.MutableLiveData;

import com.example.mvvm_recycler_suggested_retrofit.model.User;
import com.example.mvvm_recycler_suggested_retrofit.remote.APIService;
import com.example.mvvm_recycler_suggested_retrofit.remote.RetroClass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepository {

    // baray enteghal live data
    private MutableLiveData<ArrayList<User>> mutableLiveData = new MutableLiveData<>();
    ArrayList<User> arrayList = new ArrayList<>();

    public UsersRepository() {
    }


    public void getUsers() {
        //api call

        APIService apiService = RetroClass.getApiService();
        Call<UsersList> call = apiService.getUsersList("reza");
        call.enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {
                if (response.isSuccessful()) {

                    for (int i = 0; i < response.body().getArrayList().size(); i++) {
                        arrayList.add(response.body().getArrayList().get(i));
                    }

                    mutableLiveData.setValue(arrayList);

                }
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {

            }
        });
    }


    //getter for mutable live data
    public MutableLiveData<ArrayList<User>> getMutableLiveData() {
        return mutableLiveData;
    }
}
