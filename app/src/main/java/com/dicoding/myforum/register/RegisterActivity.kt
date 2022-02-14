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

    companion object {
        private const val FIELD_REQUIRED = "Field tidak boleh kosong"
    }

    private val registerViewModel: RegisterViewModel by viewModels()

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            val username = binding.edtUsername.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            val fullname = binding.edtFullName.text.toString().trim()

            if (username.isEmpty()) {
                binding.edtUsername.error = FIELD_REQUIRED
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.edtPassword.error = FIELD_REQUIRED
                return@setOnClickListener
            }

            if (fullname.isEmpty()) {
                binding.edtFullName.error = FIELD_REQUIRED
                return@setOnClickListener
            }

            registerViewModel.register(username, password, fullname).observe(this) { register ->
                if (register.status.equals("success")) {
                    Toast.makeText(this, "${register.status}", Toast.LENGTH_SHORT).show()
                    val login = Intent(this, LoginActivity::class.java)
                    startActivity(login)
                    finish()
                } else {
                    Toast.makeText(this,"${register.status}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.tvHaveAccount.setOnClickListener {
            val login = Intent(this,LoginActivity::class.java)
            startActivity(login)
            finish()
        }
    }
}