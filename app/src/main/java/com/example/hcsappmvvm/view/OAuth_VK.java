package com.example.hcsappmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.webkit.CookieManager;

import com.example.hcsappmvvm.R;
import com.example.hcsappmvvm.databinding.ActivityOauthVkBinding;
import com.example.hcsappmvvm.network.VK.OAuth2;
import com.example.hcsappmvvm.viewmodel.OAuthViewModel;

public class OAuth_VK extends AppCompatActivity {

    ActivityOauthVkBinding mbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_oauth_vk);
        OAuthViewModel oAuthViewModel = new ViewModelProvider(this).get(OAuthViewModel.class);
        CookieManager.getInstance().removeAllCookies(null);
        mbinding.webviewvk.clearCache(true);
        mbinding.webviewvk.getSettings().setJavaScriptEnabled(true);
        mbinding.webviewvk.loadUrl(OAuth2.AUTH_URL);
        mbinding.webviewvk.setWebViewClient(oAuthViewModel.getClient(this));
    }
}