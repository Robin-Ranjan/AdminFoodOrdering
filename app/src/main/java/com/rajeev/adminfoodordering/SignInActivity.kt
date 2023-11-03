package com.rajeev.adminfoodordering

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.rajeev.adminfoodordering.databinding.ActivitySignBinding
import com.rajeev.adminfoodordering.modal.userModal

class SignInActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var email: String
    private lateinit var username: String
    private lateinit var nameOfRestaurant: String
    private lateinit var password: String
    private lateinit var database: DatabaseReference

    private val binding: ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // firebase auth initialization
        auth = Firebase.auth
        // firebase database initialization
        database = Firebase.database.reference

        binding.btnCreatAccount.setOnClickListener {

         //   Toast.makeText(this, "here!!", Toast.LENGTH_SHORT).show()
            email = binding.email.text.toString().trim()
            username = binding.nameSign.text.toString().trim()
            nameOfRestaurant = binding.restorentName.text.toString().trim()
            password = binding.password.text.toString().trim()

            if (username.isBlank() || email.isBlank() || password.isBlank() || nameOfRestaurant.isBlank()) {
                Toast.makeText(this, "Please fill all the field", Toast.LENGTH_SHORT).show()
            } else {
                createAccount(email, password)
            }
        }
        binding.txtAlreadyHaveAccount.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                saveUserData()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show()
            } else {
                Log.d("Account", "createAccount: Failure", task.exception)
                Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun saveUserData() {
        email = binding.email.text.toString().trim()
        username = binding.nameSign.text.toString().trim()
        nameOfRestaurant = binding.restorentName.text.toString().trim()
        password = binding.password.text.toString().trim()

        val user = userModal(email, username, nameOfRestaurant, password)
        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        // save user data Firebase database

        database.child("user").child(userId).setValue(user)
        Toast.makeText(this,"here",Toast.LENGTH_SHORT).show()
    }
}