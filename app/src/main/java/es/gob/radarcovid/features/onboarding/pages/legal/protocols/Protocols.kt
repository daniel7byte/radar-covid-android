package es.gob.radarcovid.features.onboarding.pages.legal.protocols

interface LegalInfoView {

    fun showCheckWarning()

    fun hideCheckWarning()

    fun setLegalTermsChecked()

    fun setContinueButtonEnabled(enabled: Boolean)

}

interface LegalInfoPresenter {

    fun viewReady()

    fun onLegalTermsAccepted()

    fun onConditions()

    fun onPrivacyPolicyButtonClick()

    fun onLegalTermsCheckedChange(checked: Boolean)

}

interface LegalInfoRouter {

    fun navigateToConditions()

    fun navigateToPrivacyPolicy()

}