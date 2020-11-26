package ru.alexnimas.core_api.providers

import android.content.Context

interface AppProvider {
    fun provideContext(): Context
}