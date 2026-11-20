package com.sj.suvidhaautomation

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = TextView(this)
        text.text = "SJ SUVIDHA AUTOMATION\n\nApp is running successfully!"
        text.textSize = 24f
        text.setTextColor(Color.BLACK)
        text.setBackgroundColor(Color.WHITE)
        text.gravity = android.view.Gravity.CENTER

        setContentView(text)
    }
}