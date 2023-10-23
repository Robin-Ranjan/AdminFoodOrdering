package com.rajeev.adminfoodordering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajeev.adminfoodordering.adapter.DeliveryAdapter
import com.rajeev.adminfoodordering.databinding.ActivityOutForDeliveryBinding

class OutForDelivery : AppCompatActivity() {
    private val binding: ActivityOutForDeliveryBinding by lazy {
        ActivityOutForDeliveryBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imageButton.setOnClickListener{
            finish()
        }

        val customerName = arrayListOf(
            "Rajeev", "Ranjan", "Vikash Yadav"
        )
        val moneyStatus = arrayListOf(
            "received", "notReceived", "Pending"
        )

        val adapter = DeliveryAdapter(customerName,moneyStatus)
        binding.deliveryRecycler.adapter = adapter
        binding.deliveryRecycler.layoutManager = LinearLayoutManager(this)


    }
}