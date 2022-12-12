package com.example.hcsappmvvm.interfaces;

public interface AuthStaffListener {
    void onSuccessModerator();
    void onSuccessAdministator();
    void onFailure(String message);
}
