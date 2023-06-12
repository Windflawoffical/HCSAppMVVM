package com.example.hcsappmvvm.model;

import java.util.List;

public class Appeal {
    private int id;
    public String title;
    public String description;
    public String address;
    public String status;

    public Appeal(String title, String description,String image, String address,String status) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.status = status;
    }

    public Appeal(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
