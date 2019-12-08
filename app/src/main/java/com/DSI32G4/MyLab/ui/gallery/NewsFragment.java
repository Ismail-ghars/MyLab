package com.DSI32G4.MyLab.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.DSI32G4.MyLab.R;

public class NewsFragment extends Fragment {

  
    public WebView mWebView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Corps du Fragment Actualité
        View view=inflater.inflate(R.layout.fragment_actuality, container, false);
        mWebView = (WebView) view.findViewById(R.id.webview);
        mWebView.loadUrl("https://www.google.com/search?q=analyse+m%C3%A9dicale&sxsrf=ACYBGNRQj6m23QSPQv6Hnh7IlfWSqlkcLg:1575795870986&source=lnms&tbm=nws&sa=X&ved=2ahUKEwj8s4OJ2aXmAhUPnxQKHffIAvYQ_AUoA3oECBAQBQ&biw=1707&bih=803");

        mWebView.setWebViewClient(new WebViewClient());

        return view;


    }
}