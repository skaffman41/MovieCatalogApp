package ru.alexnimas.core_api.providers

import android.content.Context
import androidx.navigation.NavController

interface AppProvider {
    fun provideContext(): Context
    fun provideNavController(): NavController
}