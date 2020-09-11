package com.vanr.starwarsplanet.domain.usecases.planet.getplanet

import com.vanr.starwarsplanet.domain.base.BaseUseCase
import com.vanr.starwarsplanet.domain.base.SchedulerProvider
import com.vanr.starwarsplanet.domain.repositories.PlanetRepository
import com.vanr.starwarsplanet.domain.repositories.model.planet.Planet
import com.vanr.starwarsplanet.domain.usecases.planet.getplanet.GetPlanetUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class DefaultGetPlanetUseCase @Inject constructor(
    schedulerProvider: SchedulerProvider,
    var planetRepository: PlanetRepository
) : BaseUseCase<String, Planet>(schedulerProvider),
    GetPlanetUseCase {

    override fun buildUseCase(arg: String): Flowable<Planet> {
        return planetRepository.getPlanet().toFlowable()
    }

}