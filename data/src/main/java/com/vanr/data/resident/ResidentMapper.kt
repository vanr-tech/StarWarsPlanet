package com.vanr.data.resident

import com.vanr.data.resident.model.ResidentResponse
import com.vanr.starwarsplanet.domain.repositories.model.resident.Resident

class ResidentMapper {

    fun transform(residentResponse: ResidentResponse): Resident {
        return Resident(
            residentResponse.name,
            residentResponse.height,
            residentResponse.mass,
            residentResponse.hairColor,
            residentResponse.skinColor,
            residentResponse.eyeColor,
            residentResponse.birthYear,
            residentResponse.gender,
            residentResponse.homeworld,
            residentResponse.created,
            residentResponse.edited,
            residentResponse.imageUrl
        )
    }
}