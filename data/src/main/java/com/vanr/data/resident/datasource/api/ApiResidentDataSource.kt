package com.vanr.data.resident.datasource.api

import com.vanr.data.resident.datasource.ResidentDataSource
import com.vanr.data.resident.model.ResidentResponse
import io.reactivex.Single
import javax.inject.Inject

class ApiResidentDataSource @Inject constructor(val residentApi: ResidentApi): ResidentDataSource {

    override fun getResident(residentId: Int): Single<ResidentResponse> {
        return residentApi.getResident(residentId);
    }
}