package com.example.hcsappmvvm.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.view.adapter.AppealAdapter;
import com.example.hcsappmvvm.viewmodel.AppealsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AppealsActivity extends AppCompatActivity {

    private AppealsViewModel appealsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appeals);

        RecyclerView recyclerView = findViewById(R.id.RecyclerViewAppeals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final AppealAdapter appealAdapter = new AppealAdapter();
        recyclerView.setAdapter(appealAdapter);

        appealsViewModel = new ViewModelProvider(this).get(AppealsViewModel.class);
        appealsViewModel.getAllAppeals().observe(this, appealAdapter::setAppealRooms);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                appealsViewModel.delete(appealAdapter.getAppealAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getApplicationContext(), "Appeal deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        appealAdapter.setOnItemClickListener(appealRoom -> {
            Intent intent = new Intent(this, EditAppealActivity.class);
            intent.putExtra("AppealTitle",appealRoom.getTitle());
            intent.putExtra("AppealDescription",appealRoom.getDescription());
            intent.putExtra(AddAppealActivity.EXTRA_ID,appealRoom.getId());
            if(appealRoom.getImage()!=null){
                intent.putExtra("AppealImage",appealRoom.getImage());
            }
            startActivity(intent);
            finish();
        });

        FloatingActionButton button = findViewById(R.id.addAppeal);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AddAppealActivity.class);
            startActivity(intent);
        });

    }
}