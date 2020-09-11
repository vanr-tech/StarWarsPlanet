package com.vanr.data.planet

import com.vanr.data.planet.datasource.PlanetDataSource
import com.vanr.starwarsplanet.domain.repositories.PlanetRepository
import com.vanr.starwarsplanet.domain.repositories.model.planet.LikePlanet
import com.vanr.starwarsplanet.domain.repositories.model.planet.Planet
import io.reactivex.Single
import javax.inject.Inject

class PlanetDataRepository @Inject constructor(
    val planetDataSource: PlanetDataSource,
    val planetMapper: PlanetMapper
) : PlanetRepository {

    override fun getPlanet(): Single<Planet> {
        return planetDataSource.getPlanet().map(planetMapper::transform)
    }

    override fun likePlanet(planetId: Int): Single<LikePlanet> {
        return planetDataSource.likePlanet(planetId).map(planetMapper::transform)
    }
}