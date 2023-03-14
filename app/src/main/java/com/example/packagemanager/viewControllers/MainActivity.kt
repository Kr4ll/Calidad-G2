package com.example.packagemanager.viewControllers

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import com.example.packagemanager.R
import com.example.packagemanager.database.DataBase
import com.example.packagemanager.services.InitializerService

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (DataBase.isEmpty()) {
            InitializerService().initDataBase()
        }

        val btn: Button = findViewById(R.id.log_in_button)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, LoginMenu:: class.java)
            startActivity(intent)
        }
    }
}