package ru.alexnimas.network.di

import dagger.Binds
import dagger.Module
import dagger.Reusable
import ru.alexnimas.network.RemoteDataSource
import ru.alexnimas.network.RemoteDataSourceImpl

@Module
abstract class NetworkModuleBinds {
    @Binds
    @Reusable
    abstract fun bindsRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}