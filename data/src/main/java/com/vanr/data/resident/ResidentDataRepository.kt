package com.vanr.data.resident

import com.vanr.data.resident.datasource.ResidentDataSource
import com.vanr.starwarsplanet.domain.repositories.ResidentRepository
import com.vanr.starwarsplanet.domain.repositories.model.resident.Resident
import io.reactivex.Single
import javax.inject.Inject

class ResidentDataRepository @Inject constructor(
    val residentDataSource: ResidentDataSource,
    val residentMapper: ResidentMapper
): ResidentRepository {
    override fun getResidentInfo(residentId: Int): Single<Resident> {
        return residentDataSource.getResident(residentId).map(residentMapper::transform)
    }
}