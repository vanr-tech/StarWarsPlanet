package com.vanr.data.planet

import com.vanr.data.planet.model.LikeResponse
import com.vanr.data.planet.model.PlanetResponse
import com.vanr.starwarsplanet.domain.repositories.model.planet.LikePlanet
import com.vanr.starwarsplanet.domain.repositories.model.planet.Planet

class PlanetMapper {

    fun transform(planetResponse: PlanetResponse): Planet {
        return Planet(
            planetResponse.name,
            planetResponse.rotationPeriod,
            planetResponse.orbitalPeriod,
            planetResponse.diameter,
            planetResponse.climate,
            planetResponse.gravity,
            planetResponse.terrain,
            planetResponse.surfaceWater,
            planetResponse.population,
            planetResponse.residents,
            planetResponse.created,
            planetResponse.edited,
            planetResponse.imageUrl,
            planetResponse.likes
        )
    }

    fun transform(likeResponse: LikeResponse): LikePlanet {
        return LikePlanet(
            likeResponse.planetId,
            likeResponse.planetId
        )
    }
}