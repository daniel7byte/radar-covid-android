package es.gob.covidradar.features.splash.protocols

import es.gob.covidradar.common.view.RequestView

interface SplashView : RequestView {

    fun showNoInternetWarning()

    fun showPlayServicesRequiredDialog()

    fun finish()

}

interface SplashPresenter {

    fun viewReady()

    fun onResume()

    fun onNetworkRetryButtonClick()

    fun onNetworkDialogCloseButtonClick()

    fun onInstallPlayServicesButtonClick()

}

interface SplashRouter {

    fun navigateToPlayServicesPage()

    fun navigateToLegalInfo()

    fun navigateToOnboarding()

    fun navigateToMain()

}