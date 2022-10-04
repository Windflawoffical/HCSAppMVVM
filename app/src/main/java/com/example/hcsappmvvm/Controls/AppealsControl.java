package com.example.hcsappmvvm.Controls;

import android.content.Context;

import com.example.hcsappmvvm.mock.MockBase;
import com.example.hcsappmvvm.model.Appeal;

import java.util.ArrayList;
import java.util.UUID;

public class AppealsControl {
    private Appeal appeal;
    private static ArrayList<Appeal> appeals = new ArrayList<Appeal>();

    private String generateID(){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        return uuidAsString;
    }

    public AppealsControl(Context context,String Title, String Descriptioon) {
        Appeal appeal = new Appeal(generateID(), Title,Descriptioon);
    }

    public AppealsControl(Appeal appeal) {
        this.appeal = appeal;
    }
    public Appeal getAppeal(){
        return this.appeal;
    }

    //public static void getUnitsFromDb(Context context){}

    public static ArrayList<Appeal> getUnits(){
        return appeals;
    }
}
