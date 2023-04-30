package com.example.packagemanager.viewControllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.packagemanager.R
import com.example.packagemanager.model.Storehouse
import com.example.packagemanager.services.StoreService

class StorehouseAdapter(
    private val storehousePack: StorehouseMenu,
    private val storehouses: List<Storehouse>
) : RecyclerView.Adapter<StorehouseAdapter.StorehouseViewHolder>() {

    class StorehouseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.storehouse_name)
        val description: TextView = itemView.findViewById(R.id.storehouse_description)
        val delete: ImageView =itemView.findViewById(R.id.bin_icon2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorehouseViewHolder {
        return StorehouseViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.storehouse_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StorehouseViewHolder, position: Int) {
        val item = storehouses[position]
        holder.name.text = item.name
        holder.description.text = item.description

        holder.delete.setOnClickListener {
            if (StoreService.deleteStorehouseById(item.id)) {
                notifyItemRemoved(storehouses.indexOf(item))
                //storehouses.removeAt(storehouses.indexOf(item))
            }
        }
    }

    override fun getItemCount(): Int {
        return storehouses.size
    }
}