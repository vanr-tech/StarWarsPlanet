package com.vanr.starwarsplanet.domain

import com.vanr.starwarsplanet.domain.usecases.planet.PlanetUseCaseModule
import com.vanr.starwarsplanet.domain.usecases.resident.ResidentUseCaseModule
import dagger.Module

@Module(includes = [PlanetUseCaseModule::class, ResidentUseCaseModule::class])
class DomainModule {
}