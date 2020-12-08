package ru.alexnimas.main.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import ru.alexnimas.main.data.remote.MainApi
import ru.alexnimas.main.data.remote.MainRemoteDataSource
import ru.alexnimas.main.data.remote.MainRemoteDataSourceImpl
import ru.alexnimas.main.repo.MainRepository
import ru.alexnimas.main.repo.MainRepositoryImpl

@Module(includes = [MainModule.MainModuleBinds::class])
class MainModule {

    @Provides
    @Reusable
    fun provideApi(retrofit: Retrofit): MainApi {
        return retrofit.create(MainApi::class.java)
    }

    @Module
    abstract class MainModuleBinds {
        @Binds
        @Reusable
        abstract fun provideDataSource(remoteDataSourceImpl: MainRemoteDataSourceImpl): MainRemoteDataSource

        @Binds
        @Reusable
        abstract fun provideRepository(mainRepository: MainRepositoryImpl): MainRepository
    }
}