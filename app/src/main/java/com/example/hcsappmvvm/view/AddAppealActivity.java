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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddAppealActivity extends AppCompatActivity implements AddAppeal {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appeal);
        Button button = (Button) findViewById(R.id.confirmBtn);
        EditText title = (EditText) findViewById(R.id.TitleOfAppeal);
        EditText description = (EditText)findViewById(R.id.AppealDescription);
        Appeal appeal = new Appeal();
        appeal.setAppealTitle(title.toString());
        appeal.setAppealDescription(description.toString());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAppeal(appeal);
            }
        });
    }

    @Override
    public <T extends Appeal> void addAppeal(Appeal appeal) {
        List<Appeal> appeals = new ArrayList<>();
        appeals.add(appeal);
        Intent intent = new Intent();
        setResult(RESULT_OK,intent);
        finish();
        }
}
