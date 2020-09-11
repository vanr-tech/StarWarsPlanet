package com.vanr.data.planet.datasource.api

import com.vanr.data.planet.datasource.PlanetDataSource
import com.vanr.data.planet.model.LikeResponse
import com.vanr.data.planet.model.PlanetResponse
import io.reactivex.Single
import javax.inject.Inject

class ApiPlanetDataSource @Inject constructor(val planetApi: PlanetApi): PlanetDataSource {

    override fun getPlanet(): Single<PlanetResponse> {
        return planetApi.getPlanet()
    }

    override fun likePlanet(planetId: Int): Single<LikeResponse> {
        return planetApi.likePlanet(planetId)
    }
}