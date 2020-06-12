package com.indra.coronaradar.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CompoundButton
import android.widget.LinearLayout
import com.indra.coronaradar.R
import kotlinx.android.synthetic.main.view_cmcheckbox.view.*

class CMCheckBox @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var isChecked: Boolean = false
        set(value) {
            field = value
            checkBox.isChecked = value
        }
        get() = checkBox.isChecked

    init {
        orientation = HORIZONTAL
        LayoutInflater.from(context).inflate(R.layout.view_cmcheckbox, this)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CMCheckBox)
        val text = typedArray.getText(R.styleable.DottedTextView_android_text)
        typedArray.recycle()
        textView.text = text
        textView.setOnClickListener { checkBox.isChecked = !checkBox.isChecked }
    }

    fun setOnCheckedChangeListener(listener: CompoundButton.OnCheckedChangeListener?) {
        checkBox.setOnCheckedChangeListener(listener)
    }

}