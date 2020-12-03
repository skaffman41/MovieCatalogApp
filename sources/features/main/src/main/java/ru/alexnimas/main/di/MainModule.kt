package ru.alexnimas.main.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import ru.alexnimas.main.data.Api
import ru.alexnimas.main.data.RemoteDataSource
import ru.alexnimas.main.data.RemoteDataSourceImpl
import javax.sql.DataSource

@Module(includes = [MainModule.MainModuleBinds::class])
class MainModule {

    @Provides
    @Reusable
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Module
    abstract class MainModuleBinds {
        @Binds
        @Reusable
        abstract fun provideDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
    }

    companion object {
        const val BASE_URL = ""
    }
}