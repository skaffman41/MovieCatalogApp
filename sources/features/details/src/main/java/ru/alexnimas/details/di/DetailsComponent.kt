package ru.alexnimas.details.di

import dagger.Component
import ru.alexnimas.core_api.ProvidersFacade
import ru.alexnimas.details.MovieDetailsFragment

@Component(
    dependencies = [ProvidersFacade::class],
    modules = [DetailsModule::class]
)
interface DetailsComponent {
    fun inject(fragment: MovieDetailsFragment)

    companion object {

        fun create(providersFacade: ProvidersFacade): DetailsComponent {
            return DaggerDetailsComponent.builder().providersFacade(providersFacade).build()
        }
    }
}
