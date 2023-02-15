package com.example.packagemanager.model

import java.time.LocalDate

class MyPackage (val dbId: Int, val id: String, val deliveryDate: LocalDate, val content: String, val description: String,
                 val registrationDate: LocalDate, val loggerId: Int, val storehouseId: Int)
