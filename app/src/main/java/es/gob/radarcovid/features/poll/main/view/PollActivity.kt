package es.gob.radarcovid.features.poll.main.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import es.gob.radarcovid.R
import es.gob.radarcovid.common.base.BaseActivity
import es.gob.radarcovid.common.view.CMDialog
import es.gob.radarcovid.common.view.viewmodel.QuestionViewModel
import es.gob.radarcovid.features.poll.main.protocols.PollPresenter
import es.gob.radarcovid.features.poll.main.protocols.PollView
import es.gob.radarcovid.features.poll.question.view.QuestionFragment
import kotlinx.android.synthetic.main.activity_poll.*
import javax.inject.Inject

class PollActivity : BaseActivity(), PollView, QuestionFragment.Callback {

    companion object {

        const val REQUEST_CODE_POLL_COMPLETED = 1

        fun openForResult(activity: Activity, requestCode: Int) =
            activity.startActivityForResult(Intent(activity, PollActivity::class.java), requestCode)

    }

    @Inject
    lateinit var presenter: PollPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poll)

        initViews()
        presenter.viewReady()
    }

    private fun initViews() {
        imageButtonBack.setOnClickListener { onBackPressed() }
    }

    override fun onBackPressed() {
        presenter.onBackButtonPressed()
    }

    override fun showContent() {
        wrapperContent.visibility = View.VISIBLE
    }

    override fun hideContent() {
        wrapperContent.visibility = View.GONE
    }

    override fun showPollProgress(currentQuestion: Int, totalQuestions: Int) {
        stepIndicator.setProgress(currentQuestion, totalQuestions)
    }

    override fun getCurrentQuestion(): QuestionViewModel =
        (supportFragmentManager.findFragmentByTag(QuestionFragment.TAG) as QuestionFragment).getCurrentQuestion()

    override fun showQuestion(
        isLastQuestion: Boolean,
        question: QuestionViewModel
    ) {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.wrapperQuestion,
                QuestionFragment.newInstance(isLastQuestion, question),
                QuestionFragment.TAG
            ).commit()
    }

    override fun showSkipQuestionDialog() {
        CMDialog.createCancelableDialog(this,
            title = "",
            description = getString(R.string.question_dialog_message),
            okButtonText = getString(R.string.question_dialog_ok),
            cancelButtonText = getString(R.string.question_dialog_cancel),
            onOkButtonClick = { presenter.onContinueWithoutAnswer() },
            onCancelButtonClick = {}
        ).show()
    }

    override fun onContinueButtonClick(answers: QuestionViewModel) {
        presenter.onNextButtonClick(answers)
    }

}
