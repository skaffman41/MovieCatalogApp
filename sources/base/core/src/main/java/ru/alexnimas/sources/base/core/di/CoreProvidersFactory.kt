package ru.alexnimas.sources.base.core.di

import ru.alexnimas.core_api.providers.RepositoryProvider
import ru.alexnimas.repo.DaggerRepositoryComponent

object CoreProvidersFactory {

    fun createRepositoryBuilder(): RepositoryProvider {
        return DaggerRepositoryComponent.builder().build()
    }
}