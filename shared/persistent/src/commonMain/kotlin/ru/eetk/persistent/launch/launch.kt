package ru.eetk.persistent.launch

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.booleanPreferencesKey

private val SHOW_LAUNCH = booleanPreferencesKey("show_launch")

val Preferences.showLaunch: Boolean
    get() = this[SHOW_LAUNCH] ?: true

fun MutablePreferences.completeLaunch() {
    this[SHOW_LAUNCH] = false
}