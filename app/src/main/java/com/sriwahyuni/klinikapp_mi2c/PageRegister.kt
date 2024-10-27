package com.sriwahyuni.klinikapp_mi2c

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle

import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class PageRegister : AppCompatActivity() {
    private lateinit var txtLog : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_register)

        txtLog = findViewById(R.id.txtLog)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtLog.setOnClickListener {
            val intent = Intent(this, PageLogin::class.java)
            startActivity(intent)
        }
    }
}
