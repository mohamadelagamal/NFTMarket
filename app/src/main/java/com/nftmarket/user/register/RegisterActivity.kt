package com.nftmarket.user.register

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.nftmarket.R
import com.nftmarket.base.BaseActivity
import com.nftmarket.databinding.ActivityRegisterBinding
import com.nftmarket.user.main.HomeActivity
import com.nftmarket.user.login.LoginActivity

class RegisterActivity : BaseActivity<ActivityRegisterBinding,RegisterViewModel>(),Navigator{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding.vmRegister=viewModel
        viewModel.navigator=this
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_register
    }

    override fun makeViewModelProvider(): RegisterViewModel {
        return ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun openHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openLoginPage() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

    }
}