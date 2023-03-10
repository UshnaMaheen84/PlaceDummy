package com.example.placedummy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.enotes.api.ApiClient
import com.example.placedummy.databinding.ActivityLoginBinding
import com.example.placedummy.model.UserLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogIn : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email= binding.etUsername.text.toString()
        val password= binding.etPassword.text.toString()

        binding.loginBtn.setOnClickListener {


            if (email.isNotEmpty() && password.isNotEmpty()) {


                loginUser(email, password)
            }
//          val intent= Intent(this@LogIn, MainActivity::class.java)
//            startActivity(intent)

            }
        }

    private fun loginUser(email: String, password: String) {

        val loginRequest = UserLogin(email, password)

        val apiCall = ApiClient.getApiService().loginUser(loginRequest)




        apiCall.enqueue(object : Callback<UserLogin> {
            override fun onResponse(
                call: Call<UserLogin>,
                response: Response<UserLogin>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(applicationContext, "this is toast message", Toast.LENGTH_LONG)
                        .show()
                    val intent = Intent(this@LogIn, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }

            override fun onFailure(call: Call<UserLogin>, t: Throwable) {
                Toast.makeText(applicationContext, "" + t.localizedMessage, Toast.LENGTH_LONG)
                    .show()
                Log.e("abc", "" + t.localizedMessage)
            }
        })
    }
}
