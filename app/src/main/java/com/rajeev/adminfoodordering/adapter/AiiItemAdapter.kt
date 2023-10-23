package com.rajeev.adminfoodordering.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rajeev.adminfoodordering.databinding.ItemItemBinding

class AiiItemAdapter(
    private val menuItemName: ArrayList<String>,
    private val menuItemPrice: ArrayList<String>,
    private val menuItemImage: ArrayList<Int>
) : RecyclerView.Adapter<AiiItemAdapter.AllItemViewHolder>() {
    private val itemQuantities = IntArray(menuItemName.size) { 1 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllItemViewHolder {
        val bindings = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllItemViewHolder(bindings)
    }

    override fun onBindViewHolder(holder: AllItemViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return menuItemName.size
    }


    inner class AllItemViewHolder(private val bindings: ItemItemBinding) :
        RecyclerView.ViewHolder(bindings.root) {
        fun bind(position: Int) {
            bindings.apply {
                val quantity = itemQuantities[position]
                foodNameTextView.text = menuItemName[position]
                priceTextView.text = menuItemPrice[position]
                foodImageView.setImageResource(menuItemImage[position])
                itemQuanity.text = quantity.toString()
                minusButton.setOnClickListener {
                    decreaseQuantity(position)
                }

                plusButton.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteButtton.setOnClickListener {
                    deleteItem(position)
                }
            }
        }

        private fun deleteItem(position: Int) {
            menuItemName.removeAt(position)
            menuItemImage.removeAt(position)
            menuItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, menuItemName.size)
        }

        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                bindings.itemQuanity.text = itemQuantities[position].toString()
            }
        }

        private fun decreaseQuantity(position: Int) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                bindings.itemQuanity.text = itemQuantities[position].toString()
            }
        }

    }
}