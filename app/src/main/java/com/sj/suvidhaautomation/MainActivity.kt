package com.sj.suvidhaautomation

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setBackgroundColor(Color.WHITE)

        val title = TextView(this)
        title.text = "SJ SUVIDHA AUTOMATION"
        title.textSize = 21f
        title.setTextColor(Color.WHITE)
        title.setPadding(18, 22, 18, 22)
        title.setBackgroundColor(Color.rgb(25, 55, 100))
        layout.addView(title)

        val buttons = LinearLayout(this)
        buttons.orientation = LinearLayout.HORIZONTAL

        webView = WebView(this)

        fun addButton(label: String, action: () -> Unit) {
            val button = Button(this)
            button.text = label
            button.setOnClickListener { action() }

            buttons.addView(
                button,
                LinearLayout.LayoutParams(
                    0,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    1f
                )
            )
        }

        addButton("OPEN PORTAL") {
            webView.loadUrl("https://suvidha-mp.wb.gov.in/")
        }

        addButton("BACK") {
            if (webView.canGoBack()) webView.goBack()
        }

        addButton("RELOAD") {
            webView.reload()
        }

        layout.addView(buttons)

        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        webView.webChromeClient = WebChromeClient()

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                return false
            }
        }

        layout.addView(
            webView,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        setContentView(layout)
    }

    override fun onDestroy() {
        webView.destroy()
        super.onDestroy()
    }
}