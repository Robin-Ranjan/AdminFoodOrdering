package com.rajeev.adminfoodordering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajeev.adminfoodordering.adapter.AiiItemAdapter
import com.rajeev.adminfoodordering.databinding.ActivityAllItemBinding

class AllItemActivity : AppCompatActivity() {
    private val bindings:ActivityAllItemBinding by lazy {
        ActivityAllItemBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindings.root)

        val menuFoodName = listOf("Burger","momo","sandwich","item","Burger","momo")
        val menuPrice = listOf("$35","$56","$45","$89","$78","90")
        val menuImage = listOf(R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu1,
        )

        val adapter  = AiiItemAdapter(ArrayList(menuFoodName),
            ArrayList(menuPrice), ArrayList(menuImage)
        )
        bindings.allItemRecycler.layoutManager = LinearLayoutManager(this)
        bindings.allItemRecycler.adapter = adapter

        bindings.imageButton.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}