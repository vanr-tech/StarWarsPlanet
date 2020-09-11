package com.vanr.data.resident

import com.vanr.data.resident.datasource.api.ApiResidentDataSource
import com.vanr.data.resident.datasource.api.ResidentApi
import com.vanr.starwarsplanet.domain.repositories.ResidentRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ResidentDataModule {

    @Provides
    fun residentApi(retrofit: Retrofit): ResidentApi {
        return retrofit.create(ResidentApi::class.java)
    }

    @Provides
    fun apiResidentDataSource(residentApi: ResidentApi): ApiResidentDataSource {
        return ApiResidentDataSource(residentApi)
    }

    @Provides
    fun residentMapper(): ResidentMapper {
        return ResidentMapper()
    }

    @Provides
    fun residentRepository(apiResidentDataSource: ApiResidentDataSource, residentMapper: ResidentMapper): ResidentRepository {
        return ResidentDataRepository(apiResidentDataSource, residentMapper)
    }
}