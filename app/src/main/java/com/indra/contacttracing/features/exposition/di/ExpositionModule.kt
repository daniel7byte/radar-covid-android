package com.indra.contacttracing.features.exposition.di

import com.indra.contacttracing.common.di.scope.PerActivity
import com.indra.contacttracing.features.exposition.presenter.ExpositionPresenterImpl
import com.indra.contacttracing.features.exposition.protocols.ExpositionPresenter
import com.indra.contacttracing.features.exposition.protocols.ExpositionView
import com.indra.contacttracing.features.exposition.view.ExpositionActivity
import dagger.Module
import dagger.Provides

@Module
class ExpositionModule {

    @Provides
    fun providesView(activity: ExpositionActivity): ExpositionView = activity

    @Provides
    @PerActivity
    fun providesPresenter(presenter: ExpositionPresenterImpl): ExpositionPresenter = presenter

}