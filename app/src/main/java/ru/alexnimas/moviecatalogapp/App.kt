package ru.alexnimas.moviecatalogapp

import androidx.appcompat.app.AppCompatActivity
import androidx.multidex.MultiDexApplication
import ru.alexnimas.core_api.AppWithFacade
import ru.alexnimas.core_api.ProvidersFacade
import ru.alexnimas.moviecatalogapp.di.FacadeComponent
import ru.alexnimas.sources.base.core.di.CurrentActivityProvider

class App : AppWithFacade, MultiDexApplication(), CurrentActivityProvider {

    override var currentActivity: AppCompatActivity? = null

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