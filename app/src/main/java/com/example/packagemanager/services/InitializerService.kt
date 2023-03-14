package com.example.packagemanager.services

import android.os.Build
import androidx.annotation.RequiresApi

class InitializerService {

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