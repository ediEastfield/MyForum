package com.dicoding.myforum.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dicoding.myforum.MainActivity
import com.dicoding.myforum.R
import com.dicoding.myforum.databinding.ActivityLoginBinding
import com.dicoding.myforum.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(this)
        binding.tvCreateAccount.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_login-> {
                val username = binding.edtUsername.text.toString()
                val password = binding.edtPassword.text.toString()
                login(username, password)
            }
            R.id.tv_createAccount-> {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun login(username: String, password: String) {
        val main = Intent(this,MainActivity::class.java)
        startActivity(main)
        finish()
    }
}