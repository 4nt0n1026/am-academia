package com.acad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebAppActivity extends Activity {

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_app);

		WebView viewWebApp = (WebView) findViewById(R.id.webView);

		WebSettings webSettings = viewWebApp.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		viewWebApp.setWebViewClient(new MyCustomWebViewClient());
		viewWebApp.loadUrl("http://192.168.0.199:8080/AMAcademiaJSF/xhtml_mobile/mHome.xhtml");
	}
	
	private class MyCustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
	
}
