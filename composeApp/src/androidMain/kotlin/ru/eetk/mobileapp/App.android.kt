package ru.eetk.mobileapp

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.defaultComponentContext
import component.RootComponentImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.eetk.di.KoinInjector
import ru.eetk.persistent.appearance.Theme
import ru.eetk.theme.EETKTheme
import ui.RootScreen

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        KoinInjector.koinApp.androidContext(this)
        activityInject()
    }

    private fun activityInject() {
        this.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {

            override fun onActivityResumed(activity: Activity) {
                KoinInjector.koin.loadModules(listOf(module {
                    single { activity }
                }))
            }

            override fun onActivityPaused(activity: Activity) {
                KoinInjector.koin.unloadModules(listOf(module {
                    single { activity }
                }))
            }


            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

            override fun onActivityStarted(activity: Activity) {}

            override fun onActivityStopped(activity: Activity) {}

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

            override fun onActivityDestroyed(activity: Activity) {}


        })
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val root = RootComponentImpl(defaultComponentContext())
        setContent {
            RootScreen(
                component = root
            )
        }
    }
}

internal actual fun openUrl(url: String?) {
    val uri = url?.let { Uri.parse(it) } ?: return
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = uri
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    AndroidApp.INSTANCE.startActivity(intent)
}