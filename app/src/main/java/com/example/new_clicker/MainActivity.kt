package com.example.new_clicker

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val engine = Engine()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val balance_display:TextView = findViewById(R.id.Balance_text)
        val main_button:ImageButton = findViewById(R.id.mainButton)

        main_button.setOnClickListener{
            engine.click_action();
            balance_display.setText(engine._balance.toString())
        }
    }
}