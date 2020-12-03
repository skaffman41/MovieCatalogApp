package ru.alexnimas.core_api

import ru.alexnimas.core_api.providers.AppProvider
import ru.alexnimas.core_api.providers.CoordinatorsProvider
import ru.alexnimas.core_api.providers.NetworkProvider

interface ProvidersFacade : CoordinatorsProvider, AppProvider, NetworkProvider