package com.vanr.starwarsplanet.domain.usecases.planet

import com.vanr.starwarsplanet.domain.usecases.planet.getplanet.DefaultGetPlanetUseCase
import com.vanr.starwarsplanet.domain.usecases.planet.getplanet.GetPlanetUseCase
import com.vanr.starwarsplanet.domain.usecases.planet.likeplanetusecase.DefaultLikePlanetUseCase
import com.vanr.starwarsplanet.domain.usecases.planet.likeplanetusecase.LikePlanetUseCase
import dagger.Module
import dagger.Provides

@Module
class PlanetUseCaseModule {

    @Provides
    fun getPlanetUseCase(defaultGetPlanetUseCase: DefaultGetPlanetUseCase): GetPlanetUseCase {
        return defaultGetPlanetUseCase
    }

    @Provides
    fun likePlanetUseCase(defaultLikePlanetUseCase: DefaultLikePlanetUseCase): LikePlanetUseCase {
        return defaultLikePlanetUseCase
    }
}