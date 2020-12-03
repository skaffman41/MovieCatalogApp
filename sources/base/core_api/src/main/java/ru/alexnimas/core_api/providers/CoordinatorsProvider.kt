package ru.alexnimas.core_api.providers

import ru.alexnimas.core_api.coordinator.*

interface CoordinatorsProvider {
    fun provideActorCoordinator(): ActorCoordinator
    fun provideDetailsCoordinator(): DetailsCoordinator
    fun provideFilterCoordinator(): FilterCoordinator
    fun provideMainCoordinator(): MainCoordinator
    fun provideSplashCoordinator(): SplashCoordinator
    fun provideTrailerCoordinator(): TrailerCoordinator
}