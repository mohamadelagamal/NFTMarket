package com.nftmarket.user.main.ui.home.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.nftmarket.R
import com.nftmarket.base.BaseActivity
import com.nftmarket.databinding.ActivityAddBinding

class AddActivity : BaseActivity<ActivityAddBinding,AddViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getLayoutID(): Int {
        return R.layout.activity_add
    }

    override fun makeViewModelProvider(): AddViewModel {
       return ViewModelProvider(this).get(AddViewModel::class.java)
    }
}