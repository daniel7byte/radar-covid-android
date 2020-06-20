package es.gob.covidradar.features.poll.completed.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import es.gob.covidradar.R
import es.gob.covidradar.common.base.BaseActivity
import es.gob.covidradar.features.poll.completed.protocols.PollCompletedPresenter
import es.gob.covidradar.features.poll.completed.protocols.PollCompletedView
import kotlinx.android.synthetic.main.activity_poll_completed.*
import javax.inject.Inject


class PollCompletedActivity : BaseActivity(), PollCompletedView {

    companion object {

        fun open(context: Context) =
            context.startActivity(Intent(context, PollCompletedActivity::class.java))

    }

    @Inject
    lateinit var presenter: PollCompletedPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poll_completed)

        initViews()
        presenter.viewReady()
    }

    private fun initViews() {
        textViewEmail.setOnClickListener { sendMailTo(getString(R.string.poll_completed_email)) }
        buttonMain.setOnClickListener { finish() }
    }


    private fun sendMailTo(to: String) {
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "plain/text"
            putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
            putExtra(Intent.EXTRA_SUBJECT, "Subject")
            putExtra(Intent.EXTRA_TEXT, "Text")
        }

        startActivity(
            Intent.createChooser(
                emailIntent,
                "Send mail..."
            )
        )
    }
}