package com.vanr.data.planet

import com.vanr.data.planet.datasource.api.ApiPlanetDataSource
import com.vanr.data.planet.datasource.api.PlanetApi
import com.vanr.starwarsplanet.domain.repositories.PlanetRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class PlanetDataModule {
    @Provides
    fun providePlanetApi(retrofit: Retrofit): PlanetApi {
        return retrofit.create(PlanetApi::class.java)
    }

    @Provides
    fun apiPlanetDataSource(planetApi: PlanetApi): ApiPlanetDataSource {
        return ApiPlanetDataSource(planetApi);
    }

    @Provides
    fun planetMapper(): PlanetMapper {
        return PlanetMapper()
    }

    @Provides
    fun apiPlanetRepository(apiPlanetDataSource: ApiPlanetDataSource, planetMapper: PlanetMapper): PlanetRepository {
        return PlanetDataRepository(apiPlanetDataSource, planetMapper)
    }
}