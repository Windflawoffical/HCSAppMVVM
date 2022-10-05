package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.model.Appeal;

import java.util.ArrayList;

public class ListAppealsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_appeals);
    }
}