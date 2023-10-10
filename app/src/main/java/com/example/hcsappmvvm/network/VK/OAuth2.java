package com.example.hcsappmvvm.network.VK;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.lifecycle.Observer;

import com.example.hcsappmvvm.BuildConfig;
import com.example.hcsappmvvm.CurrentUser;
import com.example.hcsappmvvm.view.HomeActivity;
import com.example.hcsappmvvm.view.OAuth_VK;
import com.google.gson.Gson;

import java.io.File;

public class OAuth2 {
    public static VkApiBase vkApiBase = new VkApiBase();
    public static final String AUTH_URL =
            "https://oauth.vk.com/authorize" +
                    "?client_id=" + BuildConfig.CLIENT_ID +
                    "&display=mobile"+
                    "&scope=email,offline" +
                    "&redirect_uri=https://oauth.vk.com/blank.html&display=mobile&response_type=token&v=5.131";

    public static final String RESPONSE_URL_PATTERN = "https://oauth.vk.com/blank.html";

    public static WebViewClient getWebViewClient(OAuth_VK auth_vk) {
        return new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String urlString = request.getUrl().toString();
                if (urlString.contains(RESPONSE_URL_PATTERN)) {
                    CurrentUser.getInstance().access_token = Uri.parse(urlString.replace("#", "?")).getQueryParameter("access_token");
                    CurrentUser.getInstance().userId = Uri.parse(urlString.replace("#", "?")).getQueryParameter("user_id");
                    //Логика после удалённой авторизации через OAuth2.0
                    vkApiBase.getPersonInfo().observe(auth_vk, user -> {
                        if(user.response != null){
                            Log.e("NEED TO CHECK", "User firstName = " + user.response.firstname);
                            Intent intent = new Intent(auth_vk, HomeActivity.class);
                            intent.putExtra("Who's come", "User");
                            intent.putExtra("User", new Gson().toJson(user));
                            auth_vk.startActivity(intent);
                        }
                    });
                    return false;
                }
                view.loadUrl(urlString);
                return true;
            }
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        };
    }
}
