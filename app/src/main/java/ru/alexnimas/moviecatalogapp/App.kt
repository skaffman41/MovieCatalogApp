package ru.alexnimas.moviecatalogapp

import android.app.Application
import ru.alexnimas.core_api.AppWithFacade
import ru.alexnimas.core_api.ProvidersFacade
import ru.alexnimas.moviecatalogapp.di.FacadeComponent

class App : Application(), AppWithFacade {
    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
    }

    override fun getFacade(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).apply {
            facadeComponent = this
        }
    }

    companion object {
        private var facadeComponent: FacadeComponent? = null
    }
}