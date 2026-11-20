package com.sj.suvidhaautomation

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import android.widget.LinearLayout
import android.widget.Button
import android.view.ViewGroup
import android.view.Gravity
import android.graphics.Color
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val layout = LinearLayout(this)
            layout.orientation = LinearLayout.VERTICAL

            val header = TextView(this)
            header.text = "SJ SUVIDHA AUTOMATION"
            header.textSize = 20f
            header.setTextColor(Color.WHITE)
            header.setBackgroundColor(Color.rgb(25, 55, 100))
            header.gravity = Gravity.CENTER
            header.setPadding(10, 20, 10, 20)

            layout.addView(header)

            val reload = Button(this)
            reload.text = "RELOAD PORTAL"

            layout.addView(reload)

            webView = WebView(this)

            webView.settings.apply {
    javaScriptEnabled = true
    domStorageEnabled = true

    // Enable desktop website
    useWideViewPort = true
    loadWithOverviewMode = true
    setSupportZoom(true)
    builtInZoomControls = true
    displayZoomControls = false

    // Request desktop website
    userAgentString = userAgentString.replace(
        "Mobile",
        ""
    )
}
            webView.settings.textZoom = 75
            webView.settings.useWideViewPort = true
            webView.settings.loadWithOverviewMode = true

            webView.webViewClient = WebViewClient()
            webView.webChromeClient = WebChromeClient()

            layout.addView(
                webView,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    0,
                    1f
                )
            )

            reload.setOnClickListener {
                webView.reload()
            }

            setContentView(layout)

            webView.loadUrl("https://suvidha-mp.wb.gov.in/")

        } catch (e: Exception) {
            val error = TextView(this)
            error.text = "Startup error: ${e.message}"
            error.textSize = 18f
            setContentView(error)
        }
    }

    override fun onDestroy() {
        if (::webView.isInitialized) {
            webView.stopLoading()
            webView.destroy()
        }
        super.onDestroy()
    }
}