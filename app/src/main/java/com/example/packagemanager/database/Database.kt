package com.example.packagemanager.database

import com.example.packagemanager.model.MyPackage
import com.example.packagemanager.model.Storehouse
import com.example.packagemanager.model.User

object DataBase: AbstractDatabase() {

    private var storehouseList: ArrayList<Storehouse> = ArrayList()
    private var userList: ArrayList<User> = ArrayList()
    private var packageList: ArrayList<MyPackage> = ArrayList()

    override fun saveStorehouse(store: Storehouse) {
        storehouseList.add(store)
    }

    override fun findAllStorehouses(): List<Storehouse> {
        return storehouseList
    }

    fun findStorehouseById(id: Int): Storehouse? {
        for (storehouse in storehouseList) {
            if (storehouse.id == id)
                return storehouse
        }
        return null
    }

    fun deleteStorehouseById(id: Int): Boolean {
        var deleted = false

        for (storehouse in storehouseList) {
            if (storehouse.id == id) {
                for (ePackage in findPackagesByStorehouseId(id))
                    deletePackageById(ePackage.dbId)
                storehouseList.remove(storehouse)
                deleted = true
                break
            }
        }
        return deleted
    }

    override fun saveUser(user: User) {
        userList.add(user)
    }

    override fun findUserByNameAndPassword(name: String, password: String): User? {
        for (user in userList) {
            if (user.name == name)
                return if (user.password == password) user else null
        }

        return null
    }

    override fun savePackage(newPackage: MyPackage) {
        packageList.add(newPackage)
    }

    override fun findPackageById(id: Int): MyPackage? {
        for (ePackage in packageList) {
            if (ePackage.dbId == id)
                return ePackage
        }

        return null
    }

    override fun findPackagesByStorehouseId(id: Int): ArrayList<MyPackage> {
        var list = ArrayList<MyPackage>()

        for (ePackage in packageList) {
            if (ePackage.storehouseId == id)
                list.add(ePackage)
        }

        return list
    }

    override fun deletePackageById(id: Int): Boolean {
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

    override fun isEmpty(): Boolean {
        return storehouseList.isEmpty() && userList.isEmpty() && packageList.isEmpty()
    }
}