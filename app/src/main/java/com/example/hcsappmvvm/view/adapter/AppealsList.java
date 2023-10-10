package com.example.hcsappmvvm.view.adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.model.Appeal;
import com.example.hcsappmvvm.network.retrofit.AppealAPI;
import com.example.hcsappmvvm.network.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppealsList extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appeals_list);

        recyclerView = findViewById(R.id.AppealsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadAppeals();
    }

    private void loadAppeals() {
        RetrofitService retrofitService = new RetrofitService();
        AppealAPI appealAPI = retrofitService.getRetrofit().create(AppealAPI.class);
        appealAPI.getAllAppeals().enqueue(new Callback<List<Appeal>>() {
            @Override
            public void onResponse(Call<List<Appeal>> call, Response<List<Appeal>> response) {
                populateListView(response.body());
            }

            @Override
            public void onFailure(Call<List<Appeal>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Failed to load appeals!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateListView(List<Appeal> appealList) {
        AppealAdapter appealAdapter = new AppealAdapter(appealList);
        recyclerView.setAdapter(appealAdapter);
    }
}