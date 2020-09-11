package com.vanr.starwarsplanet.ui.main.residentDetails

import androidx.lifecycle.ViewModel
import com.vanr.starwarsplanet.base.di.ViewModelKey
import com.vanr.starwarsplanet.domain.usecases.planet.getplanet.GetPlanetUseCase
import com.vanr.starwarsplanet.domain.usecases.resident.getresident.GetResidentUseCase
import com.vanr.starwarsplanet.ui.main.planetDetails.PlanetDetailsViewModel
import com.vanr.starwarsplanet.ui.main.residentDetails.ResidentDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ResidentDetailsModule {
    @Binds
    @IntoMap
    @ViewModelKey(ResidentDetailsViewModel::class)
    abstract fun bindResidentDetailsViewModel(residentDetailsViewModel: ResidentDetailsViewModel) : ViewModel

    companion object {
        @Provides
        fun viewModel(getResidentUseCase: GetResidentUseCase): ResidentDetailsViewModel {
            return ResidentDetailsViewModel(getResidentUseCase)
        }
    }
}