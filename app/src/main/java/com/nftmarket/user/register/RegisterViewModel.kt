package com.nftmarket.user.register

import android.util.Log
import androidx.databinding.ObservableField
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nftmarket.base.BaseViewModel
import com.nftmarket.database.addUserToFireStore
import com.nftmarket.model.ApplicationUser
import com.nftmarket.model.DataUtil

class RegisterViewModel: BaseViewModel<Navigator>() {

    var username = ObservableField<String>()
    var password = ObservableField<String>()
    var email = ObservableField<String>()
    var usernameError = ObservableField<String>()
    var passwordError = ObservableField<String>()
    var emailError = ObservableField<String>()
    var phone = ObservableField<String>()
    var phoneError = ObservableField<String>()
    var  uid:String ?=null
    val auth = Firebase.auth

    fun openHome(){
        if (validation()){
            createAccount()
        }
    }
    fun openLoginPage(){
        navigator?.openLoginPage()
    }
    private fun createAccount() {
        showLoading.value=true
        auth.createUserWithEmailAndPassword(email.get()!!,password.get()!!).addOnCompleteListener {task->
            showLoading.value=false
            when {
                task.isSuccessful -> {
                    uid = task.result.user?.uid
                    createFireStoreUser(task.result.user?.uid)
                }
                else->{
                    messageLiveData.value=task.exception?.localizedMessage
                    Log.e("firebase","filed"+task.exception?.localizedMessage)
                }
            }
        }
    }
    private fun createFireStoreUser(uid: String?) {
       // showLoading.value=true
        val appUser = ApplicationUser(
            id = uid,
            userName = username.get(),
            email = email.get(),
            phone = phone.get()
        )
        addUserToFireStore(appUser ,
            OnSuccessListener {
                showLoading.value=false
                DataUtil.user = appUser
                navigator?.openHome()
            }, OnFailureListener {
                showLoading.value=false
                messageLiveData.value=it.localizedMessage
            })
    }
    fun validation():Boolean{
        var valid = true
        if (username.get().isNullOrBlank()){
            usernameError.set("please enter your name")
            valid=false
        }else{
            usernameError.set(null)
        }
        if (email.get().isNullOrBlank()){
            emailError.set("please enter your email")
            valid=false
        }else{
            emailError.set(null)
        }
        if (password.get().isNullOrBlank()){
            passwordError.set("please enter your password")
            valid=false
        }else{
            passwordError.set(null)
        }
        if (phone.get().isNullOrBlank()){
            phoneError.set("please enter your phone")
            valid=false
        }else{
            phoneError.set(null)
        }
        return valid
    }
}