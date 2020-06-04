package com.indra.contacttracing.common.di.module

import com.indra.contacttracing.features.health.di.HealthModule
import com.indra.contacttracing.features.health.view.HealthFragment
import com.indra.contacttracing.features.helpline.di.HelplineModule
import com.indra.contacttracing.features.helpline.view.HelplineFragment
import com.indra.contacttracing.features.home.di.HomeModule
import com.indra.contacttracing.features.home.view.HomeFragment
import com.indra.contacttracing.features.profile.di.ProfileModule
import com.indra.contacttracing.features.profile.view.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentsModule {

    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun bindsHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [HealthModule::class])
    abstract fun bindsHealthFragment(): HealthFragment

    @ContributesAndroidInjector(modules = [ProfileModule::class])
    abstract fun bindsProfileFragment(): ProfileFragment

    @ContributesAndroidInjector(modules = [HelplineModule::class])
    abstract fun bindsHelplineFragment(): HelplineFragment
}