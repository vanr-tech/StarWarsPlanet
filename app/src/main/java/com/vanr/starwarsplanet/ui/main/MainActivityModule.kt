package com.vanr.starwarsplanet.ui.main

import androidx.lifecycle.ViewModel
import com.vanr.starwarsplanet.base.di.ViewModelKey
import com.vanr.starwarsplanet.domain.usecases.planet.getplanet.GetPlanetUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel) : ViewModel

    companion object {
        @Provides
        fun viewModel(): MainViewModel {
            return MainViewModel()
        }
    }
}