package com.nftmarket.user.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.nftmarket.R
import com.nftmarket.base.BaseActivity
import com.nftmarket.databinding.ActivityLoginBinding
import com.nftmarket.user.main.HomeActivity
import com.nftmarket.user.register.RegisterActivity

class LoginActivity : BaseActivity<ActivityLoginBinding,LoginViewModel>(),Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding.vmLogin= viewModel
        viewModel.navigator=this
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun makeViewModelProvider(): LoginViewModel {
       return ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun newAccount() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    override fun openHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}