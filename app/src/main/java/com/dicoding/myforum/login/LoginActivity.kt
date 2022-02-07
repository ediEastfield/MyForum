package com.dicoding.myforum.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.dicoding.myforum.MainActivity
import com.dicoding.myforum.core.data.Resource
import com.dicoding.myforum.databinding.ActivityLoginBinding
import com.dicoding.myforum.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()

            loginViewModel.login(username, password).observe(this) { login ->
                if (login != null) {
                    when (login) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this,"Login Success", Toast.LENGTH_SHORT).show()
                            val main = Intent(this, MainActivity::class.java)
                            startActivity(main)
                            finish()
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this, "${login.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        binding.tvCreateAccount.setOnClickListener{
            val register = Intent(this, RegisterActivity::class.java)
            startActivity(register)
            finish()
        }
    }
}