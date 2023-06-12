package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.google.gson.Gson;

public class AddNewModer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_moder);

        Button button = findViewById(R.id.buttonexit);
        EditText editText = findViewById(R.id.IDForNewModer);

        button.setOnClickListener((view -> {
            Toast.makeText(this, "Id for new moderator set successfully", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("Who's come", "Administrator");
            startActivity(intent);
        }));


    }
}