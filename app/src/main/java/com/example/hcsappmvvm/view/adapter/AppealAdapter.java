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

    //For Room
    private List<AppealRoom> appealRooms = new ArrayList<>();
    //For mysql
    private List<Appeal> appeals = new ArrayList<>();
    private onItemClickListener listener;

    //For mysql
    public AppealAdapter(List<Appeal> appealList){
        this.appeals = appealList;
    }

    @NonNull
    @Override
    public AppealHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appeal_itemmysql, parent, false);
        return new AppealHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppealHolder holder, int position) {
        //For mysql
        Appeal appeal = appeals.get(position);
        holder.textViewTitle.setText(appeal.getTitle());
        holder.textViewDescription.setText(appeal.getDescription());
        holder.textViewAddress.setText(appeal.getAddress());


        /*For room
        AppealRoom currentAppeal = appealRooms.get(position);
        holder.textViewTitle.setText(currentAppeal.getTitle());
        holder.textViewDescription.setText(currentAppeal.getDescription());
        holder.textViewAddress.setText(currentAppeal.getAddress());
        if(currentAppeal.getStatus() != null){
            holder.textViewStatus.setText(currentAppeal.getStatus());
        } else {
            holder.textViewStatus.setText(null);
        }*/

        //TODO: Images
        /*if(currentAppeal.getImage() != null){
            holder.imageView.setImageURI(Uri.parse(currentAppeal.getImage()));
        }*/
    }

    @Override
    public int getItemCount() {
        /*For Room
        return appealRooms.size();*/
        //For mysql
        return appeals.size();
    }

    public void setAppealRooms(List<AppealRoom> appealRooms) {
        this.appealRooms = appealRooms;
        notifyDataSetChanged();
    }

    public AppealRoom getAppealAt(int position) {
        return appealRooms.get(position);
    }

    class AppealHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewAddress;
        //for Room
        //private TextView textViewStatus;
        //TODO: Images
        //private ImageView imageView;

        public AppealHolder(View view) {
            super(view);
            textViewTitle = view.findViewById(R.id.text_view_title);
            textViewDescription = view.findViewById(R.id.text_view_description);
            textViewAddress = view.findViewById(R.id.text_view_address);
            //for Room
            //textViewStatus = view.findViewById(R.id.text_view_status);
            //TODO: Images
            //imageView = view.findViewById(R.id.imageViewList);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION)
                        listener.onItemClick(appealRooms.get(position));
                }
            });
        }
    }

    public interface onItemClickListener {
        void onItemClick(AppealRoom appealRoom);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }
}
