package com.example.hcsappmvvm.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.interfaces.AddAppeal;
import com.example.hcsappmvvm.model.Appeal;
import com.example.hcsappmvvm.view.adapter.AppealAdapter;
import com.example.hcsappmvvm.viewmodel.AppealsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

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
        appealsViewModel.getAllAppeals().observe(this, new Observer<List<AppealRoom>>() {
            @Override
            public void onChanged(List<AppealRoom> appealRooms) {
                appealAdapter.setAppealRooms(appealRooms);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                appealsViewModel.delete(appealAdapter.getAppealAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getApplicationContext(),"Appeal deleted",Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);


        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.addAppeal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddAppealActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            String title = data.getStringExtra("AppealTitle");
            String description = data.getStringExtra("AppealDescription");

            AppealRoom appealRoom = new AppealRoom(title, description);
            appealsViewModel.insert(appealRoom);

            Toast.makeText(getApplicationContext(), "Appeal saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Appeal not saved", Toast.LENGTH_SHORT).show();
        }
    }
}