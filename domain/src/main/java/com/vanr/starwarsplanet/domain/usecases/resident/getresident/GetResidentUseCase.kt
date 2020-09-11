package com.vanr.starwarsplanet.domain.usecases.resident.getresident

import com.vanr.starwarsplanet.domain.repositories.model.resident.Resident
import io.reactivex.Single

interface GetResidentUseCase {
    fun asSingle(residentId: Int): Single<Resident>
}