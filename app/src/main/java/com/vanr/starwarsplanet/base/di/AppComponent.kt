package com.vanr.starwarsplanet.base.di

import android.app.Application
import com.vanr.data.DataModule
import com.vanr.starwarsplanet.App
import com.vanr.starwarsplanet.domain.DomainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ViewModelFactoryModule::class,
    AppModule::class,
    ActivityBuilderModule::class,
    DataModule::class,
    DomainModule::class
])
interface AppComponent: AndroidInjector<App> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent
    }
}