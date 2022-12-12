package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.hcsappmvvm.R;

public class AddNewModer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_moder);

        Button button = findViewById(R.id.buttonexit);
        EditText editText = findViewById(R.id.IDForNewModer);

        button.setOnClickListener((view -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }));


    }
}