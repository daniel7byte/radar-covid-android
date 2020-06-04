package com.indra.contacttracing.features.splash.router

import android.content.Context
import android.content.Intent
import com.indra.contacttracing.features.main.view.MainActivity
import com.indra.contacttracing.features.onboarding.pages.legal.view.LegalInfoFragment
import com.indra.contacttracing.features.onboarding.view.OnboardingActivity
import com.indra.contacttracing.features.splash.protocols.SplashRouter
import javax.inject.Inject

class SplashRouterImpl @Inject constructor(private val context: Context) : SplashRouter {

    override fun navigateToLegalInfo() {
        context.startActivity(Intent(context, LegalInfoFragment::class.java))
    }

    override fun navigateToOnboarding() {
        context.startActivity(Intent(context, OnboardingActivity::class.java))
    }

    override fun navigateToMain() {
        context.startActivity(Intent(context, MainActivity::class.java))
    }

}