package com.example.packagemanager.viewControllers

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.packagemanager.R
import com.example.packagemanager.services.PackageService

class ViewPackage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.package_view)

        val data: Bundle = intent.extras ?: return
        val id = data.getInt("ID")

        val pack= PackageService.findPackageById(id) ?: return

        val idField: TextView = findViewById(R.id.package_id_data)
        idField.text = pack.id
        val deliveryDateField: TextView = findViewById(R.id.delivery_date_data)
        deliveryDateField.text = pack.deliveryDate.toString()
        val creationDateField: TextView = findViewById(R.id.creation_date_data)
        creationDateField.text = pack.registrationDate.toString()
        val contentField: TextView = findViewById(R.id.content_data)
        contentField.text = pack.content
        val descriptionField: TextView = findViewById(R.id.desciption_data)
        descriptionField.text = pack.description

        val homeButton: ImageView = findViewById(R.id.home_button2)
        homeButton.setOnClickListener {
            val intent: Intent = Intent(this, PackageMenu:: class.java)
            startActivity(intent)
        }
    }
}