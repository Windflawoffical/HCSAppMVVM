package com.example.hcsappmvvm.model;

import android.content.Intent;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User extends Intent implements Serializable {
    private String email;
    private String phone;
    private String fullname;
    private String address;

    public User(String email, String phone, String fullname, String address) {
        this.email = email;
        this.phone = phone;
        this.fullname = fullname;
        this.address = address;
    }
    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
