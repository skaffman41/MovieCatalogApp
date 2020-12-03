package ru.alexnimas.sources.base.core.di

import androidx.appcompat.app.AppCompatActivity

interface CurrentActivityProvider {
    var currentActivity: AppCompatActivity?
    val isStarted: Boolean get() = currentActivity != null
}
