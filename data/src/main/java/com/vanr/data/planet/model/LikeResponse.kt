package com.vanr.data.planet.model

import com.google.gson.annotations.SerializedName

data class LikeResponse(
    @SerializedName("planet_id")
    val planetId: Int,
    val likes: Int
)