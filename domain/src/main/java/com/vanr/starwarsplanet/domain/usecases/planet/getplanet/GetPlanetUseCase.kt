package com.vanr.starwarsplanet.domain.usecases.planet.getplanet

import com.vanr.starwarsplanet.domain.repositories.model.planet.Planet
import io.reactivex.Single

interface GetPlanetUseCase {
    fun asSingle(arg: String): Single<Planet>
}