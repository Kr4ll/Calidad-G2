package com.example.packagemanager.viewControllers

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.packagemanager.R
import com.example.packagemanager.services.StoreService

class AddStorehouse : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_storehouse)

        val btn: ImageView = findViewById(R.id.home_button3)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, StorehouseMenu:: class.java)
            startActivity(intent)
        }

        val btn2: Button = findViewById(R.id.add_storehouse_button)
        btn2.setOnClickListener {
            val nameField : EditText = findViewById(R.id.et_add_storehouse_name)
            val name = nameField.text.toString()
            val descriptionField : EditText = findViewById(R.id.et_add_storehouse_description)
            val description = descriptionField.text.toString()
            val addressField : EditText = findViewById(R.id.et_add_storehouse_address)
            val address = addressField.text.toString()

            if (StoreService.saveStorehouse(name, description, address) == 0) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Fallo al añadir un nuevo almacén")
                builder.setMessage("Algún campo del formulario está vacío. Complételo y añada de nuevo el almacén")
                builder.setPositiveButton(android.R.string.yes) {dialog, which ->
                    Toast.makeText(applicationContext,
                        android.R.string.yes, Toast.LENGTH_SHORT).show()
                }
                builder.show()
            } else {
                val intent: Intent = Intent(this, StorehouseMenu:: class.java)
                startActivity(intent)
            }
        }
    }
}
