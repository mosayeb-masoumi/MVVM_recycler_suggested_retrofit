package com.example.mvvm_recycler_suggested_retrofit.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvvm_recycler_suggested_retrofit.R;
import com.example.mvvm_recycler_suggested_retrofit.databinding.ActivityMainBinding;
import com.example.mvvm_recycler_suggested_retrofit.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        UserViewModel userViewModel = new UserViewModel(this);
        mainBinding.setUser(userViewModel);

    }
}
