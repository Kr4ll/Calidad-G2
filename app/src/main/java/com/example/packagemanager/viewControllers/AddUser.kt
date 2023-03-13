package com.example.packagemanager.viewControllers

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.example.packagemanager.R
import com.example.packagemanager.services.UserService

class AddUser : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_user)

        val btn: ImageView = findViewById(R.id.home_button3)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, AdminMenu::class.java)
            startActivity(intent)
        }

        val btn2: Button = findViewById(R.id.add_button)
        btn2.setOnClickListener {
            val usernameField : EditText = findViewById(R.id.et_add_user_name)
            val username = usernameField.text.toString()
            val passField : EditText = findViewById(R.id.et_add_user_password)
            val pass = passField.text.toString()
            val adminField : CheckBox = findViewById(R.id.check_user_admin)
            val storeField : EditText = findViewById(R.id.et_add_user_store)
            try {
                val store = storeField.text.toString().toInt()
                UserService.saveUser(username,pass,adminField.isChecked,store)
            }
            catch(nfe: NumberFormatException){
                val intent: Intent = Intent(this, AddUser:: class.java)
                startActivity(intent)
            }

            val intent: Intent = Intent(this, AdminMenu:: class.java)
            startActivity(intent)
        }
    }
}