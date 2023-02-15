package com.example.packagemanager.viewControllers

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import com.example.packagemanager.R
import com.example.packagemanager.database.DataBase
import com.example.packagemanager.services.PackageService
import com.example.packagemanager.services.StoreService
import com.example.packagemanager.services.UserService

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (DataBase.isEmpty()) {
            initDataBase()
        }

        val btn: Button = findViewById(R.id.log_in_button)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, LoginMenu:: class.java)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun initDataBase(){
        StoreService.saveStorehouse("Almacen1", "Almacén de suplementación deportiva", "C/URJC n32")
        StoreService.saveStorehouse("Almacen2", "Almacén de ropa", "C/URJC n30")
        UserService.saveUser("admin","adminpass", true, 0)
        UserService.saveUser("user","pass", false, 1)
        PackageService.savePackage("AVX1123","28/11/2022","Proteína", "Paquete a entregar en Getafe, C/Aventador, n12 3B", 2, 1)
        PackageService.savePackage("BCF1124","25/11/2022","Harina de avena + Multivitamínico", "Paquete a entregar en Alcorcón, C/Conde Encina, n23", 2, 1)
    }
}