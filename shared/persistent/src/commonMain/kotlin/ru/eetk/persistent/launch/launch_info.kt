package ru.eetk.persistent.launch

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.intPreferencesKey

private val COURSE_INFO = intPreferencesKey("course_info")

val Preferences.courseInfo: Int?
    get() = this[COURSE_INFO]

fun MutablePreferences.setCourse(course: Int) {
    this[COURSE_INFO] = course
}