package com.dicoding.myforum.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dicoding.myforum.R
import com.dicoding.myforum.databinding.ActivityLoginBinding

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
                Toast.makeText(this,"Login",Toast.LENGTH_SHORT).show()
            }
            R.id.tv_createAccount-> {
                Toast.makeText(this,"Create Account",Toast.LENGTH_SHORT).show()
            }
        }
    }
}