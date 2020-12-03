package ru.alexnimas.splash

import androidx.navigation.NavController
import ru.alexnimas.core_api.coordinator.SplashCoordinator
import javax.inject.Inject

class SplashCoordinatorImpl @Inject constructor(
    private val navController: NavController
) : SplashCoordinator {
    override fun toMainScreen() {
        navController.navigate(R.id.mainFragment)
    }
}