package ru.alexnimas.network.di

import dagger.Component
import ru.alexnimas.network.Api
import ru.alexnimas.network.RemoteDataSource

@Component(
    modules = [NetworkModule::class, NetworkModuleBinds::class])
interface NetworkComponent {
    fun provideApi(): Api
    fun provideRemoteDataSource(): RemoteDataSource
}
