package ru.alexnimas.splash

import ru.alexnimas.core_api.coordinator.SplashCoordinator
import ru.alexnimas.sources.base.core.base.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val splashCoordinator: SplashCoordinator
) : BaseViewModel() {
    fun toMainScreen() {
        splashCoordinator.toMainScreen()
    }
}