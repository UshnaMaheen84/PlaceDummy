package com.example.placedummy.fragments

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.placedummy.R
import com.example.placedummy.adapter.DealerAdapter
import com.example.placedummy.api.ApiInterface
import com.example.placedummy.api.ApiServices
import com.example.placedummy.databinding.FragmentDealerBinding
import com.example.placedummy.model.AddDealerData
import com.example.placedummy.model.Dealer
import com.example.placedummy.model.DealerModel
import com.example.placedummy.model.DealerRequestLogin
import com.example.placedummy.network.ApiClient
import com.google.gson.Gson
import com.google.gson.JsonElement
import okhttp3.internal.notify
import org.json.JSONObject
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DealerFragment : Fragment() {

    lateinit var binding: FragmentDealerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    lateinit var adapter: DealerAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var tv: TextView
    lateinit var path: String
    var CreatedByEmployee = false
    var SubDealer = false

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentDealerBinding.inflate(inflater, container, false)
        val view: View = inflater.inflate(R.layout.fragment_dealer, null)


        binding.dealerIncrement.setOnClickListener {
            addDealers()
        }


        Log.e("log1", "working")
//           getData()
        getDealersData()

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addDealers() {

        Log.e("logAddDealers","works")
        binding.dealerRecyclerview.visibility = View.GONE
        binding.deleteSubdealer.visibility = View.GONE
        binding.addDealersScroll.visibility = View.VISIBLE

 //       val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        // val date = LocalDateTime.now().format(formatter).toString()

        val formatter = SimpleDateFormat("yyyy MM dd HH:mm:ss a")

        val date = formatter.format(Date()).toString()

//
//        val getFileResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//
//                if (it.resultCode == AppCompatActivity.RESULT_OK) {
//                    Log.e("success3", "succ")
//                    if (it.data?.data != null) {
//                        path = Uri.parse(it.data!!.data.toString()).toString()
//                        Log.e("getit", path.toString())
//                        binding.addProfileImagePath.text= path
//
//                    }
//
//                }
//
//            }
        binding.addProfileImagePath.setOnClickListener {

//            val intent2 = Intent(Intent.ACTION_OPEN_DOCUMENT)
//            intent2.setType("image/*")
//            intent2.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
//            getFileResult.launch(intent2)

        }
        binding.male.setOnClickListener {
            binding.addGenger.text = "Male"
        }
        binding.female.setOnClickListener {
            binding.addGenger.text = "Female"
        }
        binding.addIsSubDealerYes.setOnClickListener {
            binding.addIsSubDealer.text = "yes"
            SubDealer = true
        }
        binding.addIsSubDealerNo.setOnClickListener {
            binding.addIsSubDealer.text = "no"
            SubDealer = false
        }



        binding.btnAddDealer.setOnClickListener {
            Log.e("log7", "works")

             val dealerId = binding.addDealerId.text.toString()
            val dealerCompanyId = binding.addDealerCompanyId.text.toString()
            val companyName = binding.addDcDealerCompany.text.toString()
            val dccompany = binding.addDcDealerCompany.text.toString()
            val profileImagePath = "path"
            val name = binding.addName.text.toString()
            val email = binding.addEmail.text.toString()
            val phoneNumber1 = binding.addPhoneNumber1.text.toString()
            val phoneNumber2 = binding.addPhoneNumber2.text.toString()
            val address1 = binding.addAddress1.text.toString()
            val address2 = binding.addAddress2.text.toString()
            val gender = binding.addGenger.text.toString()
            val cnic = binding.addCnic.text.toString()
            val password = binding.addPassword.text.toString()
            val rePassword = binding.addRePassword.text.toString()
            val passwordHash= binding.addPassword.text.toString()
            val dataOfRegistration = date
            val isSubDealer = SubDealer
            val createdDate = date.toString()
            val createdBy = binding.addCreatedby.text.toString()
            val modifiedDate = date
            val modifiedBy = binding.addModifiedBy.text.toString()

            Log.e("log8", "works")

//            val data2 = AddDealerData(1, 1, "address2", "address2",
//                profileImagePath, "ushna", "email", "phoneNumber1", "phoneNumber2",
//                "address1", "address2", "gender", "cnic", "password", "rePassword",
//                "2023-02-20T21:24:35.707", isSubDealer, "2023-02-20T21:24:35.707",
//                isCreatedByEmployee, 1, "2023-02-20T21:24:35.707", 1)

            val data = AddDealerData(
                1, 1, companyName, dccompany, profileImagePath,
                name, email, phoneNumber1, phoneNumber2, address1, address2, gender, cnic,
                password, rePassword, passwordHash ,
                dataOfRegistration, isSubDealer, createdDate, 1, modifiedDate, 1
            )

            val call = ApiClient.MyClientSingleton.getClient().addDealerData(data)

            call.enqueue(object : Callback<Int?> {
                override fun onResponse(call: Call<Int?>, response: Response<Int?>) {

                    Log.e("log9", name)

                    binding.addDealersScroll.visibility = View.GONE
                    binding.deleteSubdealer.visibility = View.VISIBLE
                    binding.dealerRecyclerview.visibility = View.VISIBLE


                    Toast.makeText(context, "successful", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Int?>, t: Throwable) {

                    Log.e("log99", t.message.toString())

                    Toast.makeText(context, "try again", Toast.LENGTH_SHORT).show()
                }
            })


        }

    }

    private fun getDealersData() {
        val call = ApiClient.MyClientSingleton.getClient().getDealers()

        call.enqueue(object : Callback<DealerModel> {
            override fun onResponse(call: Call<DealerModel>, response: Response<DealerModel>) {
                if (response.isSuccessful) {
                    val list = response.body()!!.dealers
                    adapter = DealerAdapter(list)
                    binding.dealerRecyclerview.layoutManager = LinearLayoutManager(context)
                    binding.dealerRecyclerview.adapter = adapter

                    binding.dealerSearch.setOnQueryTextListener(object :
                        SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            return false
                        }

                        override fun onQueryTextChange(newText: String?): Boolean {
                            if (newText != null) {
                                adapter.filterlist(newText)
                            }
                            return true
                        }
                    })
                } else {
                    Toast.makeText(requireContext(), response.message(), Toast.LENGTH_LONG).show()
                    Log.e("failureError", response.message())
                }
            }

            override fun onFailure(call: Call<DealerModel>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_LONG).show()
                Log.e("failureErrorException", t.message!!)
            }

        })
    }

//    class Dealer {
//        var Email: String = "usama@gmail.com"
//        var Password: String = "12345"
//
//    }

//    private fun getData() {
//        Log.e("log2", "working")
//
//        var email: String = "usama@gmail.com"
//        var password: String = "12345"
//
//
//        var json = HashMap<String, String>()
//        json.put("Email", email)
//        json.put("Password", password)
//
//
//        val call = ApiClient.MyClientSingleton.getClient().getData(json)
//
//
//        call.enqueue(object : Callback<JsonElement> {
//            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
//                Log.e("log4", response.toString())
//
//
//
//                val responseBody = response.body()!!
//                val list = response.body()!!.dealers
//
//                tv.text = responseBody.toString()
//                Log.e("log5", responseBody.toString())
//
//
//                adapter = DealerAdapter()
//                recyclerView.setHasFixedSize(true)
//                recyclerView.adapter = adapter
//                recyclerView.layoutManager = LinearLayoutManager(context)
//            }
//
//            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
//                Log.e("log6", t.message.toString())
//            }
//
//        })
//
////
////
////        val callCity = ApiClient.MyClientSingleton.getClient().getCity()
////        callCity.enqueue(object :Callback<JsonElement>{
////            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
////
////            }
////
////            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
////            }
////
////        })
////
//
//}

}