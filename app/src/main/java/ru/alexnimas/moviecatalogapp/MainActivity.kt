package ru.alexnimas.moviecatalogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.alexnimas.sources.base.core.di.CurrentActivityProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as? CurrentActivityProvider)?.currentActivity = this
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        (application as? CurrentActivityProvider)?.currentActivity = null
        super.onDestroy()
    }
}