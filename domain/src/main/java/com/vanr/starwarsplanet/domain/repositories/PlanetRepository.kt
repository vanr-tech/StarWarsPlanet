package com.vanr.starwarsplanet.domain.repositories

import com.vanr.starwarsplanet.domain.repositories.model.planet.LikePlanet
import com.vanr.starwarsplanet.domain.repositories.model.planet.Planet
import io.reactivex.Single

interface PlanetRepository {
    fun getPlanet(): Single<Planet>
    fun likePlanet(planetId: Int): Single<LikePlanet>
}