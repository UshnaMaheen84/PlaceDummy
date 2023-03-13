package com.example.placedummy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.enotes.api.ApiClient
import com.example.placedummy.databinding.ActivitySignupBinding
import com.example.placedummy.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUp : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val company= binding.etCompany.text.toString()
        val username= binding.etUsername.text.toString()
        val password= binding.etPassword.text.toString()
        val phone= binding.etPhoneNo.text.toString()
        val address= binding.etAddress.text.toString()

        binding.createAccount.setOnClickListener {

            val intent = Intent(this@SignUp, MainActivity::class.java)
            startActivity(intent)
            finish()
            if (company.isNotEmpty() && username.isNotEmpty()
                && password.isNotEmpty() && phone.isNotEmpty() && address.isNotEmpty()) {


                registerUser(company, username, password, phone, address)


//                val intent = Intent(this@SignUp, MainActivity::class.java)
//                startActivity(intent)
            }
        }
    }

    private fun registerUser(company: String, username: String, password: String, phone: String, address: String) {

        val registerRequest = User(company,username,password,phone,address)

        val apiCall = ApiClient.getApiService().registerUser(registerRequest)
        apiCall.enqueue(object : Callback<User> {
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                if (response.isSuccessful){
                    Toast.makeText(applicationContext,"this is toast message", Toast.LENGTH_LONG).show()

                    val intent = Intent(this@SignUp, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(applicationContext,""+t.localizedMessage, Toast.LENGTH_LONG).show()
                Log.e("abc",""+t.localizedMessage)
            }


        })






















    }
}