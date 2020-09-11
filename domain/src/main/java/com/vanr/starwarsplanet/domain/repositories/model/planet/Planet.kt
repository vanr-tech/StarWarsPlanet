package com.vanr.starwarsplanet.domain.repositories.model.planet

class Planet (
    val name: String,
    val rotationPeriod: String,
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: String,
    val population: String,
    val residents: Array<String>,
    val created: String,
    val edited: String,
    val imageUrl: String,
    val liked: String
)