package ru.alexnimas.core_impl.di

import dagger.Component
import ru.alexnimas.core_api.providers.NetworkProvider

@Component(
    modules = [NetworkModule::class]
)
interface NetworkComponent : NetworkProvider
