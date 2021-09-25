package com.stockbit.hiring

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp
import org.koin.core.context.startKoin

@HiltAndroidApp
open class App: Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO
        )
    }

//    // CONFIGURATION ---
//    open fun configureDi() =
//        startKoin {
//            provideComponent()
//        }
//
//    // PUBLIC API ---
//    open fun provideComponent() = appComponent
}