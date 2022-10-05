package com.example.hcsappmvvm.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.Room.AppealRoom;

import java.util.ArrayList;
import java.util.List;

public class AppealAdapter extends RecyclerView.Adapter<AppealAdapter.AppealHolder> {

    private List<AppealRoom> appealRooms = new ArrayList<>();

    @NonNull
    @Override
    public AppealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appeal_item,parent,false);
        return new AppealHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppealHolder holder, int position) {
        AppealRoom currentAppeal = appealRooms.get(position);
        holder.textViewTitle.setText(currentAppeal.getTitle());
        holder.textViewDescription.setText(currentAppeal.getDescription());
    }

    @Override
    public int getItemCount() {
        return appealRooms.size();
    }

    public void setAppealRooms(List<AppealRoom> appealRooms){
        this.appealRooms = appealRooms;
        notifyDataSetChanged();
    }

    class AppealHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;

        public AppealHolder(View view){
            super(view);
            textViewTitle = view.findViewById(R.id.text_view_title);
            textViewDescription = view.findViewById(R.id.text_view_description);
        }
    }
}
