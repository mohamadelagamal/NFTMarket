package com.nftmarket.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nftmarket.R
import com.nftmarket.admin.AdminActivity
import com.nftmarket.databinding.ActivityIntroBinding
import com.nftmarket.user.login.LoginActivity

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginAsUser.setOnClickListener { view->
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
        binding.loginasAdmin.setOnClickListener { view->
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

}