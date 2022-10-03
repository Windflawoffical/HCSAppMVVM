package com.example.hcsappmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hcsappmvvm.model.Appeal;

import java.util.ArrayList;

public class ListAppealsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_appeals);
    }
    private String createLiner(Appeal appeal){
        return appeal.getAppealTitle() + '\n' + appeal.getAppealDescription();
    }
    private void fillTable(ArrayList<Appeal> appeals){
        ListView listView = findViewById(R.id.unitsListView);
        String[] uns = new String[appeals.size()];

        int i = 0;
        for(Appeal unit : appeals){
            uns[i] = createLiner(unit);
            i+=1;
        }

        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, uns);

        listView.setAdapter(adapter);
    }
}