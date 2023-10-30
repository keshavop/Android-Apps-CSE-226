package com.example.web_view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wv = findViewById<View>(R.id.webview) as WebView
        val customhtml = "<html><body><h1>Welcome to App</h1>" +
                "<h2>Testing HTML in Android App</h2>" +
                "<p>It is a static webpage in Android App</p>" +
                "<body></html>"
        wv.loadData(customhtml,"text/html","UTF-8")
    }
}