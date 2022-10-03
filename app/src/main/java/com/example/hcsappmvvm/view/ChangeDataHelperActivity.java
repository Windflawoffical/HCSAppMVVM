package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.databinding.ActivityChangeDataHelperBinding;
import com.example.hcsappmvvm.interfaces.ProfileListener;
import com.example.hcsappmvvm.model.User;
import com.example.hcsappmvvm.viewmodel.ChangeDataHelperViewModel;

import java.io.Serializable;

public class ChangeDataHelperActivity extends AppCompatActivity implements ProfileListener {
    ActivityChangeDataHelperBinding activityChangeDataHelperBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityChangeDataHelperBinding = DataBindingUtil.setContentView(this, R.layout.activity_change_data_helper);
        ChangeDataHelperViewModel changeDataHelperViewModel = new ViewModelProvider(this).get(ChangeDataHelperViewModel.class);
        activityChangeDataHelperBinding.setChangeDataHelperViewModel(changeDataHelperViewModel);
        changeDataHelperViewModel.profileListener = this;

    }

    @Override
    public void ChangeData() {
        User user = new User();
        EditText email = findViewById(R.id.myemail);
        EditText fullname = findViewById(R.id.myFullName);
        EditText phone = findViewById(R.id.myPhone);
        EditText address = findViewById(R.id.myAddress);
        user.setEmail(email.getText().toString());
        user.setFullname(fullname.getText().toString());
        user.setPhone(phone.getText().toString());
        user.setAddress(address.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("useremail", user.getEmail().toString());
        intent.putExtra("userfullname", user.getFullname().toString());
        intent.putExtra("userphone", user.getPhone().toString());
        intent.putExtra("useraddress", user.getAddress().toString());
        intent.putExtra("user", (Serializable) user);
        setResult(RESULT_OK,intent);
        finish();
        Toast.makeText(this, "Data Changed", Toast.LENGTH_SHORT).show();

    }

}