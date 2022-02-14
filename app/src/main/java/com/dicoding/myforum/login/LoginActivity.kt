package com.dicoding.myforum.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.dicoding.myforum.MainActivity
import com.dicoding.myforum.core.domain.model.DataLogin
import com.dicoding.myforum.core.utils.SessionLogin
import com.dicoding.myforum.databinding.ActivityLoginBinding
import com.dicoding.myforum.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    companion object {
        private const val FIELD_REQUIRED = "Field tidak boleh kosong"
    }

    private val loginViewModel: LoginViewModel by viewModels()

    private lateinit var binding: ActivityLoginBinding

    private lateinit var dataLogin: DataLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            if (username.isEmpty()) {
                binding.edtUsername.error = FIELD_REQUIRED
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.edtPassword.error = FIELD_REQUIRED
                return@setOnClickListener
            }

            loginViewModel.login(username, password).observe(this) { login ->
                if (login.status == "success") {

                    val sessionLogin = SessionLogin(this)
                    val refreshToken = login.data?.refreshToken
                    val accessToken = login.data?.accessToken
                    dataLogin = DataLogin(refreshToken, accessToken)
                    sessionLogin.setLogin(dataLogin)


                    Toast.makeText(this, login.status, Toast.LENGTH_SHORT).show()
                    val main = Intent(this, MainActivity::class.java)
                    startActivity(main)
                    finish()
                } else {
                    Toast.makeText(this, login.status, Toast.LENGTH_SHORT).show()
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