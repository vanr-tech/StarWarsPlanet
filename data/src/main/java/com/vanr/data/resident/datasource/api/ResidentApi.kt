package com.vanr.data.resident.datasource.api

import com.vanr.data.resident.model.ResidentResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ResidentApi {

    @GET("/residents/{id}")
    fun getResident(@Path("id") residentId: Int): Single<ResidentResponse>
}