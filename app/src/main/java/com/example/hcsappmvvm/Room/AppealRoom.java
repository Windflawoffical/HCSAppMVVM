package com.example.hcsappmvvm.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.hcsappmvvm.model.Appeal;

@Entity(tableName = "appeal_table")
public class AppealRoom extends Appeal{
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "appealtitle")
    public String AppealTitle;
    @ColumnInfo(name = "appealdescription")
    public String AppealDescription;
    @ColumnInfo(name = "appealimage")
    public String image;
    @ColumnInfo(name = "appealaddress")
    public String AppealAddress;
    @ColumnInfo(name = "appealstatus")
    public String status;

    public AppealRoom(String AppealTitle, String AppealDescription, String image,String address, String status) {
        this.AppealTitle = AppealTitle;
        this.AppealDescription = AppealDescription;
        this.image = image;
        this.address = address;
        this.status = status;
    }

    public AppealRoom() {
    }

    public String getAppealTitle() {
        return AppealTitle;
    }

    public void setAppealTitle(String appealTitle) {
        AppealTitle = appealTitle;
    }

    public String getAppealDescription() {
        return AppealDescription;
    }

    public void setAppealDescription(String appealDescription) {
        AppealDescription = appealDescription;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
        appealRoom.setTitle(appeal.getTitle());
        appealRoom.setDescription(appeal.getDescription());
        appealRoom.setAddress(appeal.getAddress());
        appealRoom.setStatus(appeal.getStatus());

        return appealRoom;
    }
}
