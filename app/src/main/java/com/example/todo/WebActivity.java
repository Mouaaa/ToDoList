package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        webView = (WebView) findViewById(R.id.webView);
        WebSettings params = webView.getSettings();
        params.setJavaScriptEnabled(true);
        params.setBuiltInZoomControls(true);
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(url);
    }



    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}






