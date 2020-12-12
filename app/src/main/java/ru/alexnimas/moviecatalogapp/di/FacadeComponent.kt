package ru.alexnimas.moviecatalogapp.di

import dagger.Component
import ru.alexnimas.core_api.ProvidersFacade
import ru.alexnimas.core_api.providers.AppProvider
import ru.alexnimas.core_api.providers.NetworkProvider
import ru.alexnimas.core_impl.di.DaggerNetworkComponent
import ru.alexnimas.moviecatalogapp.App

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