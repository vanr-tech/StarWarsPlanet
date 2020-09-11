package com.vanr.data.resident.model

import com.google.gson.annotations.SerializedName

data class ResidentResponse(
    val name: String,
    val height: String,
    val mass: String,
    @SerializedName("hair_color")
    val hairColor: String,
    @SerializedName("skin_color")
    val skinColor: String,
    @SerializedName("eye_color")
    val eyeColor: String,
    @SerializedName("birth_year")
    val birthYear: String,
    val gender: String,
    val homeworld: String,
    val created: String,
    val edited: String,
    @SerializedName("image_url")
    val imageUrl: String
)