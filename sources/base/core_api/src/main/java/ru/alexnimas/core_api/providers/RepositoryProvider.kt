package ru.alexnimas.core_api.providers

import ru.alexnimas.core_api.repo.Repository

interface RepositoryProvider {
    fun provideRepository(): Repository
}