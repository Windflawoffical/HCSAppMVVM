package com.example.hcsappmvvm.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.databinding.ActivityAccBinding;
import com.example.hcsappmvvm.interfaces.RepositoryTasks;
import com.example.hcsappmvvm.model.User;
import com.example.hcsappmvvm.viewmodel.AccViewModel;

public class AccActivity extends AppCompatActivity implements RepositoryTasks {
    ActivityAccBinding activityAccBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAccBinding = DataBindingUtil.setContentView(this, R.layout.activity_acc);
        AccViewModel accViewModel = new ViewModelProvider(this).get(AccViewModel.class);
        activityAccBinding.setAccViewModel(accViewModel);
        accViewModel.repositoryTasks = this;
    }

    @Override
    public void ChangeData() {
        Intent intent = new Intent(this, ChangeDataHelperActivity.class);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("my logs", "requestCode = " + requestCode + ", result code = " + resultCode);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                TextView myemail = (TextView)findViewById(R.id.email);
                TextView myfullname = (TextView)findViewById(R.id.FullName);
                TextView myphone = (TextView)findViewById(R.id.Phone);
                TextView myaddress = (TextView)findViewById(R.id.Address);
                String email = data.getStringExtra("useremail");
                String fullname = data.getStringExtra("userfullname");
                String phone = data.getStringExtra("userphone");
                String address = data.getStringExtra("useraddress");
                myemail.setText(email);
                myfullname.setText(fullname);
                myphone.setText(phone);
                myaddress.setText(address);
            }
        }
    }
}