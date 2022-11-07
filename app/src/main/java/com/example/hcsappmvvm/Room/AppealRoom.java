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

    public AppealRoom(String title, String description, String image) {
        this.Title = title;
        this.Description = description;
        this.image = image;
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

    public static AppealRoom convertToDB(Appeal appeal){
        AppealRoom appealRoom = new AppealRoom();

        appealRoom.setId(appeal.getId());
        appealRoom.setTitle(appeal.getAppealTitle());
        appealRoom.setDescription(appeal.getAppealDescription());
        appealRoom.setImage(appeal.getImage());

        return appealRoom;
    }
}
