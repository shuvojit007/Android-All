package com.example.shobojit.onesignaldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mWebView = (WebView) findViewById(R.id.web);
              String text = "<html><body>"
                      +
                      "<style>"+
                      "p.small { line-height: 1.5; }"+

                "</style>"

                    + "<p  class=\"small\" align=\"justify\" >"


                   + getString(R.string.chairman)

                     + "</p> "

                   + "</body></html>";
                 mWebView.loadData(text, "text/html", "utf-8");
    }
}
