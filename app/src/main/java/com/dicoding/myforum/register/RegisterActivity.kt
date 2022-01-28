package com.dicoding.myforum.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dicoding.myforum.MainActivity
import com.dicoding.myforum.R
import com.dicoding.myforum.databinding.ActivityRegisterBinding
import com.dicoding.myforum.login.LoginActivity

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener(this)
        binding.tvHaveAccount.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_signUp -> {
                val username = binding.edtUsername.text.toString()
                val name = binding.edtFullName.text.toString()
                val password = binding.edtPassword.text.toString()
                register(username, name, password)
            }
            R.id.tv_haveAccount -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun register(username: String, name: String, password: String) {
        val main = Intent(this,MainActivity::class.java)
        startActivity(main)
        finish()
    }
}