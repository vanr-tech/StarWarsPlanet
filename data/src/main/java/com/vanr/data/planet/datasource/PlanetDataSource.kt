package com.vanr.data.planet.datasource

import com.vanr.data.planet.model.LikeResponse
import com.vanr.data.planet.model.PlanetResponse
import io.reactivex.Single

interface PlanetDataSource {
    fun getPlanet(): Single<PlanetResponse>
    fun likePlanet(planetId: Int): Single<LikeResponse>
}