package com.example.placedummy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.placedummy.databinding.ActivityLogin2Binding

class LogIn : AppCompatActivity() {

    lateinit var binding: ActivityLogin2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val username= binding.etUsername.text.toString()
        val password= binding.etPassword.text.toString()

        binding.loginBtn.setOnClickListener {

          val intent= Intent(this@LogIn, MainActivity::class.java)
            startActivity(intent)

            }
        }
    }
