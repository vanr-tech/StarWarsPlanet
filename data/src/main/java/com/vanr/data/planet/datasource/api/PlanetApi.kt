package com.vanr.data.planet.datasource.api

import com.vanr.data.planet.model.LikeResponse
import com.vanr.data.planet.model.PlanetResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PlanetApi {
    @GET("/planets/10")
    fun getPlanet(): Single<PlanetResponse>

    @POST("/planets/{id}/like")
    fun likePlanet(@Path("id") id: Int): Single<LikeResponse>
}