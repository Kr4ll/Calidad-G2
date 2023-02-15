package com.example.packagemanager.database

import com.example.packagemanager.model.MyPackage
import com.example.packagemanager.model.Storehouse
import com.example.packagemanager.model.User

object DataBase {

    private var storehouseList: ArrayList<Storehouse> = ArrayList()
    private var userList: ArrayList<User> = ArrayList()
    private var packageList: ArrayList<MyPackage> = ArrayList()

    fun saveStorehouse(store: Storehouse) {
        storehouseList.add(store)
    }

    fun findAllStorehouses(): List<Storehouse> {
        return storehouseList
    }

    fun saveUser(user: User) {
        userList.add(user)
    }

    fun findUserByNameAndPassword(name: String, password: String): User? {
        for (user in userList) {
            if (user.name == name)
                return if (user.password == password) user else null
        }

        return null
    }

    fun savePackage(newPackage: MyPackage) {
        packageList.add(newPackage)
    }

    fun findPackageById(id: Int): MyPackage? {
        for (ePackage in packageList) {
            if (ePackage.dbId == id)
                return ePackage
        }

        return null
    }

    fun findPackagesByStorehouseId(id: Int): ArrayList<MyPackage> {
        var list = ArrayList<MyPackage>()

        for (ePackage in packageList) {
            if (ePackage.storehouseId == id)
                list.add(ePackage)
        }

        return list
    }

    fun deletePackageById(id: Int): Boolean {
        var deleted = false

        for (ePackage in packageList) {
            if (ePackage.dbId == id) {
                packageList.remove(ePackage)
                deleted = true
                break
            }
        }

        return deleted
    }

    fun isEmpty(): Boolean {
        return storehouseList.isEmpty() && userList.isEmpty() && packageList.isEmpty()
    }
}