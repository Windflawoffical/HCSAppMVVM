package com.example.hcsappmvvm.model;

import java.util.List;

public class Appeal {
    public String AppealTitle;
    public String AppealDescription;

    public Appeal(String appealTitle, String appealDescription) {
        this.AppealTitle = appealTitle;
        this.AppealDescription = appealDescription;
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
}
