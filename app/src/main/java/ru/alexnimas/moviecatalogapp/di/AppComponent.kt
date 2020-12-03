package ru.alexnimas.moviecatalogapp.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.alexnimas.core_api.providers.AppProvider
import ru.alexnimas.moviecatalogapp.App

@Component(modules = [AppModule::class])
interface AppComponent : AppProvider {
    companion object {

        private var appComponent: AppProvider? = null

        fun create(application: App): AppProvider {
            return appComponent ?: DaggerAppComponent
                .builder()
                .application(application)
                .build().also {
                    appComponent = it
                }
        }
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: App): Builder

        fun build(): AppComponent
    }
}