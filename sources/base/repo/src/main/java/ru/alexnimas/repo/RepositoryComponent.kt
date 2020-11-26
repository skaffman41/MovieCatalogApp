package ru.alexnimas.repo

import dagger.Component
import ru.alexnimas.core_api.providers.AppProvider
import ru.alexnimas.core_api.providers.RepositoryProvider
import ru.alexnimas.network.di.NetworkComponent
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class, NetworkComponent::class],
    modules = [RepositoryModule::class]
)
interface RepositoryComponent : RepositoryProvider