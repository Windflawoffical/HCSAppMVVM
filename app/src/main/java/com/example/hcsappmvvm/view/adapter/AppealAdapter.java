package com.example.hcsappmvvm.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.Room.AppealRoom;
import com.example.hcsappmvvm.model.Appeal;

import java.util.ArrayList;
import java.util.List;

public class AppealAdapter extends RecyclerView.Adapter<AppealAdapter.AppealHolder> {

    private List<AppealRoom> appealRooms = new ArrayList<>();
    private OnItemClickListener listener;

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

    public AppealRoom getAppealAt(int position){
        return appealRooms.get(position);
    }

    class AppealHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;

        public AppealHolder(View view){
            super(view);
            textViewTitle = view.findViewById(R.id.text_view_title);
            textViewDescription = view.findViewById(R.id.text_view_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(appealRooms.get(position));
                    }

                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(AppealRoom appealRoom);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;

    }
}
