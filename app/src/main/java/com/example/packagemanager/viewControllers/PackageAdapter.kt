package com.example.packagemanager.viewControllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.packagemanager.R
import com.example.packagemanager.model.MyPackage
import com.example.packagemanager.services.PackageService

class PackageAdapter(private val menuPack: PackageMenu,
    private val packages: MutableList<MyPackage>
): RecyclerView.Adapter<PackageAdapter.PackageViewHolder>() {

    class PackageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.package_name)
        val description: TextView = itemView.findViewById(R.id.package_description)
        val delete: ImageView=itemView.findViewById(R.id.bin_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        return PackageViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.package_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        val item = packages[position]
        holder.name.text=item.id.toString()
        holder.description.text=item.content + ". " + item.description

        holder.description.setOnClickListener {
            menuPack.showPackage(item.dbId)
        }

        holder.delete.setOnClickListener {
            if (PackageService.deletePackageById(item.dbId)) {
                notifyItemRemoved(packages.indexOf(item))
                packages.removeAt(packages.indexOf(item))
            }
        }
    }

    override fun getItemCount(): Int {
        return packages.size
    }
}