package com.example.packagemanager.viewControllers

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.packagemanager.R
import com.example.packagemanager.services.StoreService

class StorehouseMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.storehouse_menu)

        val recyclerView = findViewById<RecyclerView>(R.id.storehouse_list)

        recyclerView.adapter = StorehouseAdapter(this, StoreService.findAllStorehouses())


        val btn: ImageView = findViewById(R.id.home_button)
        btn.setOnClickListener {
            triggerRebirth(this)
        }

        val btn2: ImageView = findViewById(R.id.add_storehouse_button)
        btn2.setOnClickListener {
            val intent: Intent = Intent(this, AddStorehouse:: class.java)
            startActivity(intent)
        }
    }

    fun triggerRebirth(context: Context) {
        val packageManager: PackageManager = context.getPackageManager()
        val intent = packageManager.getLaunchIntentForPackage(context.getPackageName())
        val componentName = intent!!.component
        val mainIntent = Intent.makeRestartActivityTask(componentName)
        context.startActivity(mainIntent)
        Runtime.getRuntime().exit(0)
    }
}