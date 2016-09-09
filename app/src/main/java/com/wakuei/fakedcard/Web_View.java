package com.wakuei.fakedcard;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by user on 2016/7/31/031.
 */

public class Web_View extends AppCompatActivity {
    private WebView wv1;
    private TextView tv1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.web_view);
            wv1 = (WebView)findViewById(R.id.Lwv1);
//            tv1 = (TextView)findViewById(R.id.Ltv1);

            Bundle bundle = getIntent().getExtras();
            String url = bundle.getString("Url");

            WebSettings ws=wv1.getSettings();
            ws.setJavaScriptEnabled(true);
            wv1.loadUrl(url);
        }
}
