package com.cacaocoffee.mvvmtest.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.cacaocoffee.mvvmtest.R
import com.cacaocoffee.mvvmtest.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = loginViewModel
        binding.activity = this
        binding.lifecycleOwner = this
        setObserve()
    }

    fun setObserve() {
        loginViewModel.showInputNumberActivity.observe(this) {
            if (it) {
                finish()
                startActivity(Intent(this, InputNumberActivity::class.java))
            }
        }
        loginViewModel.showFindIdActivity.observe(this) {
            if (it) startActivity(Intent(this, FindIdActivity::class.java))
        }
    }



    fun findId() {
        println("findId")
        loginViewModel.showFindIdActivity.value = true
    }
}