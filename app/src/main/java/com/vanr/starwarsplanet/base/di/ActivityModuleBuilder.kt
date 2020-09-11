package com.vanr.starwarsplanet.base.di

import com.vanr.starwarsplanet.ui.main.MainActivity
import com.vanr.starwarsplanet.ui.main.MainActivityModule
import com.vanr.starwarsplanet.ui.main.planetDetails.PlanetDetailsFragment
import com.vanr.starwarsplanet.ui.main.planetDetails.PlanetDetailsModule
import com.vanr.starwarsplanet.ui.main.residentDetails.ResidentDetailsFragment
import com.vanr.starwarsplanet.ui.main.residentDetails.ResidentDetailsModule
import com.vanr.starwarsplanet.ui.main.residentDetails.ResidentDetailsViewModel
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeAuthActivity(): MainActivity?

    @ContributesAndroidInjector(modules = [PlanetDetailsModule::class])
    abstract fun contributePlanetDetailsFragment(): PlanetDetailsFragment?

    @ContributesAndroidInjector(modules = [ResidentDetailsModule::class])
    abstract fun contributeResidentDetailsFragment(): ResidentDetailsFragment?
}