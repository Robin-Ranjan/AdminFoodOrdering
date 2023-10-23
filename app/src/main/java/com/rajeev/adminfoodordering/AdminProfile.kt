package com.rajeev.adminfoodordering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rajeev.adminfoodordering.databinding.ActivityAdminProfileBinding

class AdminProfile : AppCompatActivity() {
    private val binding:ActivityAdminProfileBinding by lazy {
        ActivityAdminProfileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imageButton.setOnClickListener {
            finish()
        }

        binding.edtName.isEnabled = false
        binding.edtAddress.isEnabled = false
        binding.edtEmail.isEnabled = false
        binding.edtPhone.isEnabled = false
        binding.edtPass.isEnabled = false

         var isEnable = false
        binding.editProfile.setOnClickListener{
            isEnable =! isEnable

            binding.edtName.isEnabled = isEnable
            binding.edtAddress.isEnabled = isEnable
            binding.edtEmail.isEnabled = isEnable
            binding.edtPhone.isEnabled = isEnable
            binding.edtPass.isEnabled = isEnable

            binding.edtName.requestFocus()
        }

    }
}