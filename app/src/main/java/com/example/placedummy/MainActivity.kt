package com.example.placedummy

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.placedummy.databinding.ActivityMainBinding
import com.example.placedummy.fragments.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        replaceFragment(HomeFragment())

        binding.bottomNav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.navigation_home -> replaceFragment(HomeFragment())

                R.id.navigation_dealer -> replaceFragment(DealerFragment())

                R.id.navigation_favorite -> replaceFragment(FavouriteFragment())

                R.id.navigation_property -> replaceFragment(PropertyFragment())

                R.id.navigation_profile -> replaceFragment(ProfileFragment())

            }

            true

        }




    }
    private fun replaceFragment( fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout, fragment)
        fragmentTransaction.commit()
    }
}