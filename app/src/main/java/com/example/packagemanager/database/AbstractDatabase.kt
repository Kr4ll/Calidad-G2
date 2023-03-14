package com.example.packagemanager.database

import com.example.packagemanager.model.MyPackage
import com.example.packagemanager.model.Storehouse
import com.example.packagemanager.model.User


abstract class AbstractDatabase {

    abstract fun saveStorehouse(store: Storehouse)

    abstract fun findAllStorehouses(): List<Storehouse>

    abstract fun saveUser(user: User)

    abstract fun findUserByNameAndPassword(name: String, password: String): User?

    abstract fun savePackage(newPackage: MyPackage)


    abstract fun findPackageById(id: Int): MyPackage?


    abstract fun findPackagesByStorehouseId(id: Int): ArrayList<MyPackage>


    abstract fun deletePackageById(id: Int): Boolean


    abstract fun isEmpty(): Boolean

}