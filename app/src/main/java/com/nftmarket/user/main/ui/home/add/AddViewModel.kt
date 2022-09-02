package com.nftmarket.user.main.ui.home.add

import androidx.databinding.ObservableField
import com.nftmarket.base.BaseViewModel

class AddViewModel: BaseViewModel<Navigator>() {

    val nftName = ObservableField<String>()
    val nftNameError = ObservableField<String>()
    val description =ObservableField<String>()
    val descriptionError = ObservableField<String>()
}