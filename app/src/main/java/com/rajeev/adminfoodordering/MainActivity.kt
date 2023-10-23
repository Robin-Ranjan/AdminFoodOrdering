package com.rajeev.adminfoodordering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rajeev.adminfoodordering.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val bindings:ActivityMainBinding  by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindings.root)

        bindings.addMenu.setOnClickListener{
            val intent = Intent(this,AddItem::class.java)
            startActivity(intent)
        }
        bindings.allItemMenu.setOnClickListener{
            val intent = Intent(this,AllItemActivity::class.java)
            startActivity(intent)
        }

        bindings.outForDeliveryButton.setOnClickListener{
            val intent = Intent(this,OutForDelivery::class.java)
            startActivity(intent)
        }

        bindings.profile.setOnClickListener {
            val intent = Intent(this,AdminProfile::class.java)
            startActivity(intent)
        }

        bindings.profile.setOnClickListener {
            val intent = Intent(this,CreateUser::class.java)
            startActivity(intent)
        }

        bindings.pendingOrder.setOnClickListener {
            val intent = Intent(this,PendingOrder::class.java)
            startActivity(intent)
        }
    }
}