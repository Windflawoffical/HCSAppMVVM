package com.example.hcsappmvvm.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.hcsappmvvm.model.Appeal;

@Entity(tableName = "appeal_table")
public class AppealRoom extends Appeal{
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    public String Title;
    @ColumnInfo(name = "description")
    public String Description;
    @ColumnInfo(name = "image")
    public String image;
    @ColumnInfo(name = "address")
    public String address;
    @ColumnInfo(name = "status")
    public String status;

    public AppealRoom(String title, String description, String image,String address, String status) {
        this.Title = title;
        this.Description = description;
        this.image = image;
        this.address = address;
        this.status = status;
    }

    public AppealRoom() {
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static AppealRoom convertToDB(Appeal appeal){
        AppealRoom appealRoom = new AppealRoom();

        appealRoom.setId(appeal.getId());
        appealRoom.setTitle(appeal.getAppealTitle());
        appealRoom.setDescription(appeal.getAppealDescription());
        appealRoom.setImage(appeal.getImage());
        appealRoom.setAddress(appeal.getAddress());
        appealRoom.setStatus(appeal.getStatus());

        return appealRoom;
    }
}
