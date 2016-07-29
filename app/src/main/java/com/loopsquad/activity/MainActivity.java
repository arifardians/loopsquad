package com.loopsquad.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private static final int THRESHOLD = 85;

    private WebView webView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.my_browser);
        progressBar = (ProgressBar) findViewById(R.id.my_progress);

        progressBar.setMax(THRESHOLD);


//        webView.setInitialScale(1);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
      /*  settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);*/
        /*settings.setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);*/

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                progressBar.setVisibility(View.VISIBLE);
                return true;
            }

        });

        // disable scroll on touch
        /*webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });*/

        String url = "http://loop.co.id/loopsquads/squad2016apps";
        webView.setWebChromeClient(new MyChromeClient());
        webView.loadUrl(url);

    }

    private class MyChromeClient extends WebChromeClient{

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if(newProgress > THRESHOLD){
                MainActivity.this.setTitle("Ramadhan Quiz");
                //progressBar.setVisibility(View.GONE);
            }else{
                MainActivity.this.setTitle("loading...");
                progressBar.setProgress(newProgress);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN){
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                        progressBar.setVisibility(View.VISIBLE);
                    } else {
                        finish();
                    }
                    return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}
