package com.rajeev.adminfoodordering.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBindings
import com.rajeev.adminfoodordering.databinding.DeliveryItemBinding

class DeliveryAdapter(private val customerName:ArrayList<String>,private val moneyStatus:ArrayList<String>) : RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {
       val binding = DeliveryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DeliveryViewHolder(binding)
    }


    override fun onBindViewHolder(holder: DeliveryViewHolder, position: Int) {
       holder.bind(position)
    }

    override fun getItemCount(): Int {
       return customerName.size
    }

    inner class DeliveryViewHolder(private val binding: DeliveryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
          binding.apply {
              customerNames.text = customerName[position]
              moneyStatues.text = moneyStatus[position]
              val colorMap = mapOf(
                  "received" to Color.GREEN,"notReceived" to Color.RED,"Pending" to Color.GRAY
              )
              moneyStatues.setTextColor(colorMap[moneyStatus[position]]?:Color.BLACK)
              statusColor.backgroundTintList = ColorStateList.valueOf(colorMap[moneyStatus[position]]?:Color.BLACK)
          }
        }
        }
}