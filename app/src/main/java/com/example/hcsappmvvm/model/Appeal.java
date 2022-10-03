package com.example.hcsappmvvm.model;

import java.util.List;

public class Appeal {
    public String AppealTitle;
    public String AppealDescription;
    public String creationTime;

    public Appeal(String appealTitle, String appealDescription, String creationTime) {
        this.AppealTitle = appealTitle;
        this.AppealDescription = appealDescription;
        this.creationTime = creationTime;
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

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
