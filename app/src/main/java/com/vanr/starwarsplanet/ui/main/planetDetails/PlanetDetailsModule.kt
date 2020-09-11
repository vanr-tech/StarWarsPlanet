package com.vanr.starwarsplanet.ui.main.planetDetails

import androidx.lifecycle.ViewModel
import com.vanr.starwarsplanet.base.di.ViewModelKey
import com.vanr.starwarsplanet.domain.usecases.planet.getplanet.GetPlanetUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class PlanetDetailsModule {

    @Binds
    @IntoMap
    @ViewModelKey(PlanetDetailsViewModel::class)
    abstract fun bindPlanetDetailsViewModel(planetDetailsViewModel: PlanetDetailsViewModel) : ViewModel

    companion object {
        @Provides
        fun viewModel(planetUseCase: GetPlanetUseCase): PlanetDetailsViewModel {
            return PlanetDetailsViewModel(planetUseCase)
        }
    }
}