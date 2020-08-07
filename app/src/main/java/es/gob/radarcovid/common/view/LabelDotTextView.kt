package es.gob.radarcovid.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import dagger.android.HasAndroidInjector
import es.gob.radarcovid.R
import es.gob.radarcovid.datamanager.utils.LabelManager
import kotlinx.android.synthetic.main.view_dotted_textview.view.*
import javax.inject.Inject


class LabelDotTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    @Inject
    lateinit var labelManager: LabelManager

    private var labelId: String?

    init {
        (context.applicationContext as HasAndroidInjector)
            .androidInjector()
            .inject(this)

        orientation = HORIZONTAL
        LayoutInflater.from(context)
            .inflate(R.layout.view_dotted_textview, this)
        context.obtainStyledAttributes(attrs, R.styleable.LabelDotTextView).apply {
            try {
                labelId = getString(R.styleable.LabelDotTextView_labelId)
                val defaultText = getText(R.styleable.LabelDotTextView_android_text)
                when (getInt(R.styleable.LabelDotTextView_dotVisibility, 0)) {
                    0 -> imageViewDot.visibility = View.VISIBLE
                    1 -> imageViewDot.visibility = View.INVISIBLE
                    2 -> imageViewDot.visibility = View.GONE
                }
                textView.text = labelManager.getText(labelId, defaultText)
            } finally {
                recycle()
            }
        }
    }

    fun setText(labelId: String?, resId: Int) {
        setText(labelId, context.getString(resId))
    }

    fun setText(labelId: String?, text: CharSequence, type: TextView.BufferType) {
        textView.setText(labelManager.getText(labelId, text), type)
    }

    fun setText(labelId: String?, defaultText: CharSequence) {
        textView.text = labelManager.getText(labelId, defaultText)
    }

    fun reloadText() {
        textView.text = labelManager.getText(labelId, textView.text)
    }
}