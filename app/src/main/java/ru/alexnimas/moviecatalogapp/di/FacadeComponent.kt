package ru.alexnimas.moviecatalogapp.di

import android.app.Application
import dagger.Component
import ru.alexnimas.core_api.ProvidersFacade
import ru.alexnimas.core_api.providers.AppProvider
import ru.alexnimas.core_api.providers.RepositoryProvider
import ru.alexnimas.moviecatalogapp.App
import ru.alexnimas.sources.base.core.di.CoreProvidersFactory

@Component(
    dependencies = [AppProvider::class, RepositoryProvider::class],
    modules = [CoordinatorsBindings::class]
)
interface FacadeComponent : ProvidersFacade {
    companion object {
        fun init(application: Application): FacadeComponent =
            DaggerFacadeComponent.builder()
                .appProvider(AppComponent.create(application))
                .repositoryProvider(CoreProvidersFactory.createRepositoryBuilder())
                .build()
    }

    fun inject(app: App)
}