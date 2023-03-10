package com.example.packagemanager.services

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.packagemanager.database.DataBase
import com.example.packagemanager.model.MyPackage
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object PackageService {

    private var idAutogenerated: Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    /**
     * Returns:
     * 0: Si todo ha ido bien y el paquete se ha podido guardar en la base de datos
     * 1: Si alguno de los campos es vacío
     * 2: Si la fecha no cumple con el formato correcto
     */
    fun savePackage(id: String, date:String, content: String, description: String, loggerId: Int, storehouseId: Int): Int {
        if (id != "" && content != "" && description != "") {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

            try {
                val formattedDate = LocalDate.parse(date, formatter)
                idAutogenerated++
                val pack = MyPackage(idAutogenerated, id, formattedDate, content, description, LocalDate.now(), loggerId, storehouseId )
                DataBase.savePackage(pack)
                return 0
            } catch (e: java.time.format.DateTimeParseException) {
                return 2
            }
        } else {
            return 1
        }
    }

    fun findPackageById(id: Int): MyPackage? {
        return DataBase.findPackageById(id)
    }

    fun findPackagesByStorehouseId(id: Int): MutableList<MyPackage> {
        return DataBase.findPackagesByStorehouseId(id)
    }

    fun deletePackageById(id: Int): Boolean {
        return DataBase.deletePackageById(id)
    }
}