package com.example.packagemanager.services.jUnitTest

import com.example.packagemanager.services.StoreService
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class StoreServiceTest {

    @Test
    fun saveStorehouse() {
        assertEquals(1, StoreService.saveStorehouse("Almacen1", "Almacén de suplementación deportiva", "C/URJC n32"));
    }
}