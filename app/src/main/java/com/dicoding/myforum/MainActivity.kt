package com.dicoding.myforum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dicoding.myforum.core.domain.model.DataLogin
import com.dicoding.myforum.core.utils.SessionLogin
import com.dicoding.myforum.databinding.ActivityMainBinding
import com.dicoding.myforum.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var sessionLogin: SessionLogin
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataLogin: DataLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionLogin = SessionLogin(this)
        dataLogin = sessionLogin.getData()
        binding.refreshToken.text = dataLogin.refreshToken
        binding.accessToken.text = dataLogin.accessToken

        checkLogin()
    }

    private fun checkLogin() {
        if (!sessionLogin.isLogin()) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}