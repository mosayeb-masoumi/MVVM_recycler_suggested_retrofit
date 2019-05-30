package com.example.mvvm_recycler_suggested_retrofit.viewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvvm_recycler_suggested_retrofit.BR;
import com.example.mvvm_recycler_suggested_retrofit.model.User;
import com.example.mvvm_recycler_suggested_retrofit.remote.user.UsersRepository;
import com.example.mvvm_recycler_suggested_retrofit.view.adapter.UserAdapter;

import java.util.ArrayList;

public class UserViewModel extends BaseObservable {

    private ArrayList<UserViewModel> arrayList = new ArrayList<>();


    private String name;
    private String phone;

    private Context context;

    public UserViewModel(Context context) {
        this.context = context;

        //api call


        UsersRepository repository = new UsersRepository();
        repository.getUsers();
        repository.getMutableLiveData().observe((LifecycleOwner) context, new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(@Nullable ArrayList<User> users) {

                for (int i = 0; i < users.size(); i++) {
                    UserViewModel userViewModel = new UserViewModel(users.get(i));
                    arrayList.add(userViewModel);
                }

                notifyPropertyChanged(BR.arrayList);
            }
        });


        //dasty
//        for (int i = 0; i <5 ; i++) {
//           User user = new User("hassan"+i , "masoumi");
//           UserViewModel userViewModel =new UserViewModel(user);
//           arrayList.add(userViewModel);
//        }
    }


    @BindingAdapter("bind:arrayListAdapter")
    public static void recyclerViewBindingAdapter(final RecyclerView recyclerView, ArrayList<UserViewModel> arrayList) {

        UserAdapter adapter = new UserAdapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

    }


    public UserViewModel(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
    }


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    @Bindable
    public ArrayList<UserViewModel> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<UserViewModel> arrayList) {
        this.arrayList = arrayList;
        notifyPropertyChanged(BR.arrayList);
    }
}
