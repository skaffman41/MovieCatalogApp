package ru.alexnimas.moviecatalogapp.di

import android.app.Application
import dagger.Component
import ru.alexnimas.core_api.ProvidersFacade
import ru.alexnimas.core_api.providers.AppProvider
import ru.alexnimas.core_api.providers.NetworkProvider
import ru.alexnimas.moviecatalogapp.App
import ru.alexnimas.network.di.DaggerNetworkComponent
import ru.alexnimas.sources.base.core.di.CoreProvidersFactory

@Component(
    dependencies = [AppProvider::class, NetworkProvider::class],
    modules = [CoordinatorsBindings::class]
)
interface FacadeComponent : ProvidersFacade {
    companion object {
        fun init(application: App): FacadeComponent =
            DaggerFacadeComponent.builder()
                .appProvider(AppComponent.create(application))
                .networkProvider(DaggerNetworkComponent.builder().build())
                .build()
    }

    fun inject(app: App)
}