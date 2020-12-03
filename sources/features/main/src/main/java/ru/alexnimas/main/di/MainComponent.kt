package ru.alexnimas.main.di

import dagger.Component
import ru.alexnimas.core_api.ProvidersFacade
import ru.alexnimas.main.MainFragment

@Component(
    dependencies = [ProvidersFacade::class],
    modules = [MainModule::class]
)
interface MainComponent {
    fun inject(fragment: MainFragment)

    companion object {

        fun create(providersFacade: ProvidersFacade): MainComponent {
            return DaggerMainComponent.builder().providersFacade(providersFacade).build()
        }
    }
}
