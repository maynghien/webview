package com.tiengiangdev.luongthevinhdoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView myWebView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.mywebview);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://thptluongthevinh.ddns.net");
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setDownloadListener((url, userAgent, contentDisposition, mimetype, contentLength) -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
    }
    @Override
    public void onBackPressed()
    {
        if(myWebView.canGoBack()){
            myWebView.goBack();
        }else{
            super.onBackPressed();
        }
    }


}