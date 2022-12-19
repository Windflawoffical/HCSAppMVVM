package com.example.hcsappmvvm.viewmodel;

import android.app.Application;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.hcsappmvvm.Room.AppealRoomRepository;
import com.example.hcsappmvvm.view.OAuth_VK;

import java.io.File;

public class OAuthViewModel extends ViewModel {

    public WebViewClient getClient(OAuth_VK auth_vk) {
        return AppealRoomRepository.getClient(auth_vk);
    }
}
