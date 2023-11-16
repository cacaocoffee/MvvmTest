package com.cacaocoffee.mvvmtest.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    var id: MutableLiveData<String> = MutableLiveData("")
    var password: MutableLiveData<String> = MutableLiveData("")

    var showInputNumberActivity: MutableLiveData<Boolean> = MutableLiveData(false)
    var showFindIdActivity: MutableLiveData<Boolean> = MutableLiveData(false)

    var auth = FirebaseAuth.getInstance()
    fun loginWithSignupEmail() {
        println("Email")
        auth.createUserWithEmailAndPassword(
            id.value.toString(),
            password.value.toString()
        ).addOnCompleteListener {
            if (it.isSuccessful) {
                showInputNumberActivity.value = true
            } else {
                //실패시
            }
        }
        showInputNumberActivity.value = true
    }
}