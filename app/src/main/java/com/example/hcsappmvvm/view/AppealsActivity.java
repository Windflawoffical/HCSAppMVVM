package com.example.hcsappmvvm.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.interfaces.AddAppeal;
import com.example.hcsappmvvm.model.Appeal;

public class AppealsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appeals);
        ImageButton button = (ImageButton) findViewById(R.id.addAppeal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddAppealActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        Button checkappeals = (Button) findViewById(R.id.CheckAppeals);
        checkappeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListAppealsActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                Toast.makeText(this,"Жалоба создана", Toast.LENGTH_SHORT).show();
            }
        }
    }
}