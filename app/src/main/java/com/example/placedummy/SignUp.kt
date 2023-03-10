package com.example.placedummy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.placedummy.databinding.ActivitySignupBinding

class SignUp : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username= binding.etUsername.text.toString()
        val password= binding.etPassword.text.toString()

        binding.createAccount.setOnClickListener {

            val intent= Intent(this@SignUp, MainActivity::class.java)
            startActivity(intent)

        }
    }
}