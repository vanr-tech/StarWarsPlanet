package com.vanr.data.resident.datasource

import com.vanr.data.resident.model.ResidentResponse
import io.reactivex.Single

interface ResidentDataSource {
    fun getResident(residentId: Int): Single<ResidentResponse>
}