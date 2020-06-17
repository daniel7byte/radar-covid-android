package com.indra.coronaradar.features.onboarding.pages.legal.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.indra.coronaradar.R
import kotlinx.android.synthetic.main.activity_privacy.*

class PrivacyActivity : AppCompatActivity() {

    companion object {

        fun open(context: Context) =
            context.startActivity(Intent(context, PrivacyActivity::class.java))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy)

        imageButtonClose.setOnClickListener { finish() }
    }

}
