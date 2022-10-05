package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.interfaces.AddAppeal;
import com.example.hcsappmvvm.model.Appeal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AddAppealActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appeal);

        editTextTitle = findViewById(R.id.TitleOfAppeal);
        editTextDescription= findViewById(R.id.AppealDescription);
        Button button = findViewById(R.id.confirmBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAppeal();
            }
        });

    }

    private void saveAppeal(){
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        if(title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(getApplicationContext(),"Please enter title and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra("AppealTitle",title);
        data.putExtra("AppealDescription",description);
        setResult(RESULT_OK,data);
        finish();
    }



}
