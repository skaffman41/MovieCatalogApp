package ru.alexnimas.details.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import ru.alexnimas.details.data.remote.DetailsApi
import ru.alexnimas.details.data.remote.DetailsRemoteDataSource
import ru.alexnimas.details.data.remote.DetailsRemoteDataSourceImpl
import ru.alexnimas.details.repo.DetailsRepository
import ru.alexnimas.details.repo.DetailsRepositoryImpl

@Module(includes = [DetailsModule.DetailsModuleBinds::class])
class DetailsModule {

    @Provides
    @Reusable
    fun provideApi(retrofit: Retrofit): DetailsApi {
        return retrofit.create(DetailsApi::class.java)
    }

    @Module
    abstract class DetailsModuleBinds {
        @Binds
        @Reusable
        abstract fun provideDataSource(remoteDataSourceImpl: DetailsRemoteDataSourceImpl): DetailsRemoteDataSource

        @Binds
        @Reusable
        abstract fun provideRepository(detailsRepository: DetailsRepositoryImpl): DetailsRepository
    }
}