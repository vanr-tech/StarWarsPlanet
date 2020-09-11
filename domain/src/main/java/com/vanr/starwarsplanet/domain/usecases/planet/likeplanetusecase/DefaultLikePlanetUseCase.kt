package com.vanr.starwarsplanet.domain.usecases.planet.likeplanetusecase

import com.vanr.starwarsplanet.domain.base.BaseUseCase
import com.vanr.starwarsplanet.domain.base.SchedulerProvider
import com.vanr.starwarsplanet.domain.repositories.PlanetRepository
import com.vanr.starwarsplanet.domain.repositories.model.planet.LikePlanet
import io.reactivex.Flowable
import javax.inject.Inject

class DefaultLikePlanetUseCase @Inject constructor(
    schedulerProvider: SchedulerProvider,
    var planetRepository: PlanetRepository
) : BaseUseCase<Int, LikePlanet>(schedulerProvider),
    LikePlanetUseCase {

    override fun buildUseCase(arg: Int): Flowable<LikePlanet> {
        return planetRepository.likePlanet(arg).toFlowable()
    }
}