package com.example.multimodule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.ui.LoginActivity
import com.example.core.modes.AppSubscription
import com.example.multimodule.di.provider.ApplicationComponentProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appSubscription: AppSubscription

    private lateinit var subscriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ApplicationComponentProvider)
            .getApplicationComponent()
            .inject(this)

        bindViews()
        bindListeners()

        showSubscription()
    }

    private fun showSubscription() {
        subscriptionTextView.text = appSubscription.getUserSubscription()
    }

    private fun startCalculatorActivity() {
        startActivity(
            Intent(this, LoginActivity::class.java)
        )
    }

    private fun bindViews() {
        subscriptionTextView = findViewById(R.id.suscription_type_textview)
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.login_button).setOnClickListener {
            startCalculatorActivity()
        }
    }
}
