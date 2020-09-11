package com.vanr.starwarsplanet.domain.usecases.resident

import com.vanr.starwarsplanet.domain.usecases.resident.getresident.DefaultGetResidentUseCase
import com.vanr.starwarsplanet.domain.usecases.resident.getresident.GetResidentUseCase
import dagger.Module
import dagger.Provides

@Module
class ResidentUseCaseModule {

    @Provides
    fun getResident(defaultGetResidentUseCase: DefaultGetResidentUseCase): GetResidentUseCase {
        return defaultGetResidentUseCase
    }
}