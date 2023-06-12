package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.view.adapter.AppealAdapter;
import com.example.hcsappmvvm.viewmodel.AppealsViewModel;


public class AppealsActivity extends AppCompatActivity {

    private AppealsViewModel appealsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appealsroom);

        RecyclerView recyclerView = findViewById(R.id.RecyclerViewAppeals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        /*For Room
        final AppealAdapter appealAdapter = new AppealAdapter();
        recyclerView.setAdapter(appealAdapter);

        appealsViewModel = new ViewModelProvider(this).get(AppealsViewModel.class);
        appealsViewModel.getAllAppeals().observe(this, appealAdapter::setAppealRooms);


        appealAdapter.setOnItemClickListener(appealRoom -> {
            Intent intent = new Intent(this, EditAppealActivity.class);
            intent.putExtra(AddAppealActivity.EXTRA_ID,appealRoom.getId());
            startActivity(intent);
            finish();
        });*/


    }
}