package com.vanr.starwarsplanet.domain.repositories

import com.vanr.starwarsplanet.domain.repositories.model.resident.Resident
import io.reactivex.Single

interface ResidentRepository {
    fun getResidentInfo(residentId: Int): Single<Resident>
}