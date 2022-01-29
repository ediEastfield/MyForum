package com.dicoding.myforum.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.dicoding.myforum.databinding.ActivityRegisterBinding
import com.dicoding.myforum.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private val registerViewModel: RegisterViewModel by viewModels()

    private lateinit var binding: ActivityRegisterBinding

    private val login = Intent(this,LoginActivity::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            val fullname = binding.edtFullName.text.toString()
            registerViewModel.register(username, password, fullname).observe(this, { register ->
                if (register != null) {
                    Toast.makeText(this,"Register Success",Toast.LENGTH_SHORT).show()
                    startActivity(login)
                    finish()
                }
            })
        }

        binding.tvHaveAccount.setOnClickListener {
            startActivity(login)
            finish()
        }
    }
}