package es.gob.covidradar.features.exposure.protocols

interface ExposureView {

    fun showExpositionLevelLow()

    fun showExpositionLevelMedium()

    fun showExpositionLevelHigh()

    fun setLastUpdateTime(date: String, daysElapsed: Int, hoursElapsed: Int, minutesElapsed: Int)

}

interface ExposurePresenter {

    fun viewReady()

    fun onResume()

    fun onReportButtonClick()

}

interface ExposureRouter {

    fun navigateToCovidReport()

}