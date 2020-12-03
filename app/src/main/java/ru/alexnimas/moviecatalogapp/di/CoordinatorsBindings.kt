package ru.alexnimas.moviecatalogapp.di

import dagger.Binds
import dagger.Module
import dagger.Reusable
import ru.alexnimas.actor.ActorCoordinatorImpl
import ru.alexnimas.core_api.coordinator.*
import ru.alexnimas.details.DetailsCoordinatorImpl
import ru.alexnimas.filter.FilterCoordinatorImpl
import ru.alexnimas.main.MainCoordinatorImpl
import ru.alexnimas.splash.SplashCoordinatorImpl
import ru.alexnimas.trailer.TrailerCoordinatorImpl

@Module
interface CoordinatorsBindings {
    @Binds
    @Reusable
    fun provideActorCoordinator(actorCoordinatorImpl: ActorCoordinatorImpl): ActorCoordinator

    @Binds
    @Reusable
    fun provideDetailsCoordinator(detailsCoordinatorImpl: DetailsCoordinatorImpl): DetailsCoordinator

    @Binds
    @Reusable
    fun provideFilterCoordinator(filterCoordinatorImpl: FilterCoordinatorImpl): FilterCoordinator

    @Binds
    @Reusable
    fun provideMainCoordinator(mainCoordinatorImpl: MainCoordinatorImpl): MainCoordinator

    @Binds
    @Reusable
    fun provideSplashCoordinator(splashCoordinatorImpl: SplashCoordinatorImpl): SplashCoordinator

    @Binds
    @Reusable
    fun provideTrailerCoordinator(trailerCoordinatorImpl: TrailerCoordinatorImpl): TrailerCoordinator
}