package com.example.login.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.R
import com.example.login.di.provider.LoginComponentProvider
import com.example.login.usecase.LoginUseCase
import com.example.login.usecase.LoginUseCase.Result.Failure
import com.example.login.usecase.LoginUseCase.Result.Success
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var loginUseCase: LoginUseCase

    private lateinit var userEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        (application as LoginComponentProvider)
            .getLoginComponent()
            .inject(this)

        bindViews()
        bindListeners()
    }

    private fun doLogin() {
        val user = userEditText.text.toString()
        val password = passwordEditText.text.toString()

        loginUseCase.execute(user, password).let {
            when (it) {
                is Success -> resultTextView.text = it.result.toString()
                is Failure -> showFailureMessage(it.message)
            }
        }
    }

    private fun showFailureMessage(message: String) {
        resultTextView.text = message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun bindViews() {
        userEditText = findViewById(R.id.username_edittext)
        passwordEditText = findViewById(R.id.password_edittext)
        resultTextView = findViewById(R.id.result_textview)
        buttonLogin = findViewById(R.id.button_login)
    }

    private fun bindListeners() {
        buttonLogin.setOnClickListener {
            doLogin()
            hideKeyboard(buttonLogin)
        }
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}