package com.example.packagemanager.viewControllers

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.packagemanager.R
import com.example.packagemanager.services.UserService

class AdminMenu : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UserService.getLoggedUser()
        setContentView(R.layout.admin_menu)

        val btn: ImageView = findViewById(R.id.back_button)
        btn.setOnClickListener {
            UserService.logOut()
            val intent: Intent = Intent(this, LoginMenu:: class.java)
            startActivity(intent)
        }

        val btn2: Button = findViewById(R.id.add_user_button)
        btn2.setOnClickListener {
            val intent: Intent = Intent(this, AddUser:: class.java)
            startActivity(intent)
        }

        val btn3: Button = findViewById(R.id.store_button)
        btn3.setOnClickListener {
            val intent: Intent = Intent(this, StorehouseMenu:: class.java)
            startActivity(intent)
        }
    }
}