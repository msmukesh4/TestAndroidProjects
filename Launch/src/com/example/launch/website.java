package com.example.launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class website extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brouser);
		
		WebView ws = (WebView) findViewById(R.id.wv);
		ws.loadUrl(getIntent().getExtras().getString("url"));
		ws.setWebViewClient(new WebViewClient());
		
		
	}
}
