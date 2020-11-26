package ru.alexnimas.repo

import dagger.Binds
import dagger.Module
import dagger.Reusable
import ru.alexnimas.core_api.repo.Repository

@Module
abstract class RepositoryModule {
    @Binds
    @Reusable
    abstract fun provideRepository(remoteDataSource: RepositoryImpl): Repository
}