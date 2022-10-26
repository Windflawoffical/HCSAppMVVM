package com.example.hcsappmvvm.model;

import java.util.List;

public class Appeal {
    public String AppealTitle;
    public String AppealDescription;
    public String image;

    public Appeal(String appealTitle, String appealDescription,String image) {
        this.AppealTitle = appealTitle;
        this.AppealDescription = appealDescription;
        this.image = image;
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
}
