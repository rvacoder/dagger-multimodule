package com.example.multimodule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.ui.LoginActivity
import com.example.core.modes.AppSubscription
import com.example.core.resource.StringsProvider
import com.example.multimodule.di.provider.ApplicationComponentProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appSubscription: AppSubscription

    @Inject
    lateinit var stringsProvider: StringsProvider

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
        Toast.makeText(this, stringsProvider.getString(R.string.app_name), Toast.LENGTH_SHORT).show()
    }

    private fun startLoginActivity() {
        startActivity(
            Intent(this, LoginActivity::class.java)
        )
    }

    private fun bindViews() {
        subscriptionTextView = findViewById(R.id.suscription_type_textview)
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.login_button).setOnClickListener {
            startLoginActivity()
        }
    }
}
