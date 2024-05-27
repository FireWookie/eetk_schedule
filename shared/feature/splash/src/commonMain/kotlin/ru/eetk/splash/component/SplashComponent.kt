package ru.eetk.splash.component

import ru.eetk.splash.component.models.SplashResult

interface SplashComponent {
    fun openScreen(splashResult: SplashResult)

    fun startDelay()
}