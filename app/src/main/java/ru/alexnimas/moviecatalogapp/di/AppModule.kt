package ru.alexnimas.moviecatalogapp.di

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dagger.Module
import dagger.Provides
import ru.alexnimas.moviecatalogapp.App
import ru.alexnimas.moviecatalogapp.R

@Module
class AppModule {
    @Provides
    fun provideContext(app: App): Context = app.applicationContext

    @Provides
    fun provideActivity(app: App): AppCompatActivity = app.currentActivity
        ?: throw IllegalStateException("Current activity must be not null. Did you forget to set your activity to MainApplication?")

    @Provides
    fun provideNavController(activity: AppCompatActivity): NavController {
        return Navigation.findNavController(activity, R.id.nav_host_fragment)
    }
}