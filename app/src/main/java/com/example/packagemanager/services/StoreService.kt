package com.example.packagemanager.services

import com.example.packagemanager.database.DataBase
import com.example.packagemanager.model.Storehouse

object StoreService {
    private var idAutogenerated: Int = 0

    fun saveStorehouse(name: String, description: String, address: String): Int {
        if (name == "" || description == "" || address == "")
            return 0

        idAutogenerated++
        DataBase.saveStorehouse(Storehouse(idAutogenerated, name, description, address))
        return 1
    }

    fun findAllStorehouses(): List<Storehouse> {
        return DataBase.findAllStorehouses()
    }

    fun findStorehouseById(id: Int): Storehouse? {
        return DataBase.findStorehouseById(id)
    }

    fun deleteStorehouseById(id: Int): Boolean {
        return DataBase.deleteStorehouseById(id)
    }
}