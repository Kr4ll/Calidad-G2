package com.example.packagemanager.viewControllers

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.example.packagemanager.R
import com.example.packagemanager.services.PackageService
import com.example.packagemanager.services.UserService

class AddPackage : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_package)

        val btn: ImageView = findViewById(R.id.home_button)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, PackageMenu:: class.java)
            startActivity(intent)
        }

        val btn2: Button = findViewById(R.id.add_button)
        btn2.setOnClickListener {
            val idField : EditText = findViewById(R.id.et_id_package)
            val id = idField.text.toString()
            val dateField : EditText = findViewById(R.id.et_date_package)
            val date = dateField.text.toString()
            val contentField : EditText = findViewById(R.id.et_content_package)
            val content = contentField.text.toString()
            val descriptionField : EditText = findViewById(R.id.et_description_package)
            val description = descriptionField.text.toString()

            val loggedUser = UserService.getLoggedUser()
            var result: Int = -1

            if (loggedUser != null) {
                result = PackageService.savePackage(id, date, content, description, loggedUser.id, loggedUser.storehouseId)
            }

            if (result != 0) {
                val builder = AlertDialog.Builder(this)
                var messageWarning : String = ""

                messageWarning = if (result == 1)
                    "Algún campo del formulario está vacío. Complételo y añada de nuevo el paquete"
                else
                    "La fecha no cumple con el formato indicado"

                builder.setTitle("Fallo al añadir un nuevo paquete")
                builder.setMessage(messageWarning)
                builder.setPositiveButton(android.R.string.yes) {_, _ ->
                    Toast.makeText(applicationContext,
                        android.R.string.yes, Toast.LENGTH_SHORT).show()
                }
                builder.show()
            } else {
                val intent: Intent = Intent(this, PackageMenu:: class.java)
                startActivity(intent)
            }
        }
    }
}