package com.example.hcsappmvvm.interfaces;

import android.content.Intent;

public interface AuthListener {
    void onSuccess();
    void onFailure(String message);
}
