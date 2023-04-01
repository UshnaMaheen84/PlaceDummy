package com.example.placedummy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.enotes.api.ApiClient
import com.example.placedummy.databinding.ActivityLoginBinding
import com.example.placedummy.model.DealerRequestLogin
import com.example.placedummy.model.UserLogin
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogIn : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()

        binding.loginBtn.setOnClickListener {


            getData()


            if (email.isNotEmpty() && password.isNotEmpty()) {


                //          loginUser(email, password)

            }
//          val intent= Intent(this@LogIn, MainActivity::class.java)
//            startActivity(intent)

        }
    }

    private fun loginUser(email: String, password: String) {

        val loginRequest = UserLogin(email, password)

        val apiCall = ApiClient.getApiService().loginUser(loginRequest)


    }

    private fun getData() {
        Log.e("log2", "working")


        val email: String = "usama@gmail.com"
        val password: String = "12345"

        val json = HashMap<String, String>()
        json.put("Email", email)
        json.put("Password", password)

        val data = DealerRequestLogin(email, password)

        val call = com.example.placedummy.network.ApiClient.MyClientSingleton.getClient().dealerLogin(data)

        call.enqueue(object : Callback<String> {


            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.e("log3","in onResponse")
                Log.e("log4", response.toString())
                if (response.isSuccessful) {

                val intent = Intent(this@LogIn, MainActivity::class.java)
                startActivity(intent)

                    val responseBody = response.body()!!
                    Log.e("log5", responseBody.toString())
                } else {
                    Toast.makeText(this@LogIn, response.message(), Toast.LENGTH_LONG).show()
                    Log.e("failureError", response.message())
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("log6", t.message.toString())
                Toast.makeText(this@LogIn, t.toString(), Toast.LENGTH_LONG).show()

            }


//            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
//                Log.e("log3", "in onResponse")
//                Log.e("log4", response.toString())
//                if (response.isSuccessful) {
//
//                    val intent = Intent(this@LogIn, MainActivity::class.java)
//                    startActivity(intent)
//
//                    val responseBody = response.body()!!
//                    Log.e("log5", responseBody.toString())
//                } else {
//                    Toast.makeText(this@LogIn, response.message(), Toast.LENGTH_LONG).show()
//                    Log.e("failureError", response.message())
//                }
//            }
//            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
//
//                Log.e("log6", t.message.toString())
//                Toast.makeText(this@LogIn, t.toString(), Toast.LENGTH_LONG).show()
//            }


        })


//
//        val callCity = com.example.placedummy.network.ApiClient.MyClientSingleton.getClient().getCity()
//        callCity.enqueue(object :Callback<JsonElement>{
//            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
//
//            }
//
//            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
//            }
//
//        })


    }

}
