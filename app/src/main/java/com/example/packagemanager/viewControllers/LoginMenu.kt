package com.example.packagemanager.viewControllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.packagemanager.R
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.packagemanager.services.UserService

class LoginMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login)

        val userField : EditText = findViewById(R.id.user_input)
        val passwordField : EditText = findViewById(R.id.password_input)

        val btn: Button = findViewById(R.id.login_button)
        btn.setOnClickListener {
            val user = userField.text.toString()
            val password = passwordField.text.toString()

            val correct = UserService.logIn(user, password)

            if (!correct) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Fallo en el inicio de sesión")
                builder.setMessage("Las credenciales son incorrectas, inténtelo de nuevo")
                builder.setPositiveButton(android.R.string.yes) {dialog, which ->
                    Toast.makeText(applicationContext,
                        android.R.string.yes, Toast.LENGTH_SHORT).show()
                }
                builder.show()
            } else {
                val loggedUser = UserService.getLoggedUser()
                if (loggedUser?.isAdmin == false){
                    val intent: Intent = Intent(this, PackageMenu:: class.java)
                    startActivity(intent)
                }
                else{
                    val user = UserService.getLoggedUser();
                    if(user!!.isAdmin){
                        val intent: Intent = Intent(this, AdminMenu:: class.java)
                        startActivity(intent)
                    }else{
                        val intent: Intent = Intent(this, PackageMenu:: class.java)
                        startActivity(intent)

                    }

                }
            }
        }
    }
}