package ru.alexnimas.splash.di

import dagger.Component
import ru.alexnimas.core_api.ProvidersFacade
import ru.alexnimas.splash.SplashFragment

@Component(
    dependencies = [ProvidersFacade::class]
)
interface SplashComponent {
    fun inject(fragment: SplashFragment)

    companion object {

        fun create(providersFacade: ProvidersFacade): SplashComponent {
            return DaggerSplashComponent.builder().providersFacade(providersFacade).build()
        }
    }
}
