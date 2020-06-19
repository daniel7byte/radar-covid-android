package es.gob.covidradar.features.poll.main.protocols

import es.gob.covidradar.common.view.RequestView
import es.gob.covidradar.common.viewmodel.QuestionViewModel

interface PollView : RequestView {

    fun showContent()

    fun hideContent()

    fun showPollProgress(currentQuestion: Int, totalQuestions: Int)

    fun getCurrentQuestion(): QuestionViewModel

    fun showQuestion(isLastQuestion: Boolean, question: QuestionViewModel)

    fun showSkipQuestionDialog()

    fun finish()

}

interface PollPresenter {

    fun viewReady()

    fun onBackButtonPressed()

    fun onNextButtonClick(currentQuestion: QuestionViewModel)

    fun onContinueWithoutAnswer()

}

interface PollRouter {

    fun navigateToPollCompleted()

}