package ru.alexnimas.main

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import ru.alexnimas.core_api.coordinator.MainCoordinator
import javax.inject.Inject

class MainCoordinatorImpl @Inject constructor(
    private val navController: NavController
) : MainCoordinator {
    override fun toDetailsScreen(id: Int) {
        val bundle = bundleOf("id" to id)
        navController.navigate(R.id.detailsFragment, bundle)
    }
}