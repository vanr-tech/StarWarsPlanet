package com.vanr.starwarsplanet.ui.main.planetDetails

import androidx.lifecycle.MutableLiveData
import com.vanr.starwarsplanet.base.ui.BaseViewModel
import com.vanr.starwarsplanet.domain.repositories.model.planet.Planet
import com.vanr.starwarsplanet.domain.usecases.planet.getplanet.GetPlanetUseCase
import javax.inject.Inject

class PlanetDetailsViewModel @Inject constructor(val planetUseCase: GetPlanetUseCase) : BaseViewModel() {

    val planetLiveData: MutableLiveData<Planet> = MutableLiveData()

    fun getPlanetDetails() {
        addDisposable(planetUseCase.asSingle("").subscribe(
            this::setLiveData,
            this::handleError
        ))
    }

    private fun setLiveData(planet: Planet) {
        planetLiveData.postValue(planet)
    }
}