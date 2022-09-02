package com.nftmarket.user.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.nftmarket.R
import com.nftmarket.databinding.ActivityHomeBinding
import com.nftmarket.user.main.ui.order.OrderFragment
import com.nftmarket.user.main.ui.home.HomeFragment
import com.nftmarket.user.main.ui.profile.ProfileFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.setOnItemSelectedListener (NavigationBarView.OnItemSelectedListener {
            if (it.itemId== R.id.navigation_profile){
                pushfragment(ProfileFragment())
            }
            else if(it.itemId==R.id.navigation_home){
                pushfragment(HomeFragment())
            }
            else if(it.itemId==R.id.navigation_ordar){
                pushfragment(OrderFragment())
            }
            return@OnItemSelectedListener true
        })

        binding.navView.selectedItemId=R.id.navigation_home

    }
    private fun pushfragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_activity_home, fragment).commit()
    }

}