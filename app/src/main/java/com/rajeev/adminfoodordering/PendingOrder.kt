package com.rajeev.adminfoodordering

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajeev.adminfoodordering.adapter.PendingOrderAdapter
import com.rajeev.adminfoodordering.databinding.ActivityPendingOrderBinding

class PendingOrder : AppCompatActivity() {
    private val binding : ActivityPendingOrderBinding by lazy {
        ActivityPendingOrderBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imageButton.setOnClickListener{
            finish()
        }

        val customerName = arrayListOf(
            "Rajeev", "Ranjan", "Vikas Yadav"
        )
        val moneyStatus = arrayListOf(
            "8", "1", "10"
        )
        val menuImage = listOf(R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
        )

        val adapter = PendingOrderAdapter(customerName,moneyStatus,menuImage,this)
        binding.pendingOrderRecycler.adapter = adapter
        binding.pendingOrderRecycler.layoutManager = LinearLayoutManager(this)
    }
}