package com.example.packagemanager.services

import com.example.packagemanager.database.DataBase
import com.example.packagemanager.model.User
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class UserServiceTest {

    @Test
    fun saveUser() {
        UserService.saveUser("user","pass", false, 1)
        val newUser = User(1, "user","pass", false, 1)
        assertEquals(newUser, DataBase.findUserByNameAndPassword("user", "pass"));
    }
}