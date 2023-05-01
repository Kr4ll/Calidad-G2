package com.example.packagemanager.services.jUnitTest

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.packagemanager.services.PackageService
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class PackageServiceTest {

    @RequiresApi(Build.VERSION_CODES.O)
    @Test
    fun savePackage() {
        assertEquals(0,
            PackageService.savePackage(
                "AVX1123",
                "28/11/2022",
                "Proteína",
                "Paquete a entregar en Getafe, C/Aventador, n12 3B",
                2,
                1
            )
        );
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Test
    fun deletePackageById() {
        PackageService.savePackage(
            "AVX1123",
            "28/11/2022",
            "Proteína",
            "Paquete a entregar en Getafe, C/Aventador, n12 3B",
            2,
            1
        );
        assertEquals(true, PackageService.deletePackageById(1));
    }
}