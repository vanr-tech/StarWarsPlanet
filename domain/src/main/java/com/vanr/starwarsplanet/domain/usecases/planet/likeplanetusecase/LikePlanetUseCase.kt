package com.vanr.starwarsplanet.domain.usecases.planet.likeplanetusecase

import com.vanr.starwarsplanet.domain.repositories.model.planet.LikePlanet
import io.reactivex.Single

interface LikePlanetUseCase {
    fun asSingle(id: Int): Single<LikePlanet>
}