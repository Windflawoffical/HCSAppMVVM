package com.example.hcsappmvvm.model;

import java.util.List;

public class Appeal {
    private int id;
    public String AppealTitle;
    public String AppealDescription;
    public String image;
    public String address;
    public String status;

    public Appeal(String appealTitle, String appealDescription,String image, String address,String status) {
        this.AppealTitle = appealTitle;
        this.AppealDescription = appealDescription;
        this.image = image;
        this.address = address;
        this.status = status;
    }


    public Appeal() {
    }

    public String getAppealTitle() {
        return AppealTitle;
    }

    public void setAppealTitle(String appealTitle) {
        this.AppealTitle = appealTitle;
    }

    public String getAppealDescription() {
        return AppealDescription;
    }
    public void setAppealDescription(String appealDescription) {
        this.AppealDescription = appealDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
