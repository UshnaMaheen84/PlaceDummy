package com.example.placedummy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.placedummy.databinding.ActivityLoginBinding

class LogIn : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username= binding.etUsername.text.toString()
        val password= binding.etPassword.text.toString()

        binding.loginBtn.setOnClickListener {

          val intent= Intent(this@LogIn, MainActivity::class.java)
            startActivity(intent)

            }
        }
    }
