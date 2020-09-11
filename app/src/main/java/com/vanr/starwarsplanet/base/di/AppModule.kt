package com.vanr.starwarsplanet.base.di


import com.vanr.starwarsplanet.base.scheduling.AndroidSchedulerProvider
import com.vanr.starwarsplanet.domain.base.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideSchedulers(androidSchedulerProvider: AndroidSchedulerProvider): SchedulerProvider {
        return androidSchedulerProvider
    }
}