package com.indra.contacttracing.features.onboarding.pages.legal.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import com.indra.contacttracing.R
import com.indra.contacttracing.common.base.BaseFragment
import com.indra.contacttracing.features.onboarding.pages.OnboardingStepPageFragment
import com.indra.contacttracing.features.onboarding.pages.legal.protocols.LegalInfoPresenter
import com.indra.contacttracing.features.onboarding.pages.legal.protocols.LegalInfoView
import kotlinx.android.synthetic.main.fragment_legal_info.*
import javax.inject.Inject

class LegalInfoFragment : BaseFragment(), LegalInfoView {

    companion object {

        fun newInstance() = LegalInfoFragment()

    }

    @Inject
    lateinit var presenter: LegalInfoPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_legal_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        presenter.viewReady()
    }

    private fun initViews() {
        checkBoxTermsAndConditions.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked ->
            presenter.onLegalTermsCheckedChange(
                isChecked
            )
        })
        buttonAccept.setOnClickListener { (activity as? OnboardingStepPageFragment.Callback)?.onContinueButtonClick() }
    }

    override fun showCheckWarning() {
        wrapperCheckWarning.visibility = View.VISIBLE
    }

    override fun hideCheckWarning() {
        wrapperCheckWarning.visibility = View.GONE
    }

    override fun setContinueButtonEnabled(enabled: Boolean) {
        buttonAccept.isEnabled = enabled
    }

}