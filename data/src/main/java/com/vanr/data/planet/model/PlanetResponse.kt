package com.vanr.data.planet.model

import com.google.gson.annotations.SerializedName

data class PlanetResponse(
    val name: String,
    @SerializedName("rotation_period")
    val rotationPeriod: String,
    @SerializedName("orbital_period")
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    @SerializedName("surface_water")
    val surfaceWater: String,
    val population: String,
    val residents: Array<String>,
    val created: String,
    val edited: String,
    @SerializedName("image_url")
    val imageUrl: String,
    val likes: String
)