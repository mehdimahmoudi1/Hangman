package com.example.hangmangame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button

import android.widget.TextView


class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val btn_restart: Button = findViewById<View>(R.id.btn_restart) as Button
        val btn_exit: Button = findViewById<View>(R.id.btn_exit) as Button


        val txt_result = findViewById<View>(R.id.txt_result) as TextView
        val intent = intent
        val result = intent.getStringExtra("RESULT")

        if (result == "Won") {
            txt_result.text = "YOU WON!"
        } else {
            txt_result.text = "Game Over!"
        }

        btn_exit.setOnClickListener { finish() }
      btn_restart.setOnClickListener {
          val intent = Intent(this@FinishActivity, MainActivity::class.java)
          this@FinishActivity.startActivity(intent)
          finish()
      }
    }
}