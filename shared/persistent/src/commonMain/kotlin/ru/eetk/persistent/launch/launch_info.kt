package ru.eetk.persistent.launch

import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import ru.eetk.persistent.launch.model.LaunchInfo

private val COURSE_INFO = intPreferencesKey("course_info")
private val COLLEGE_INFO = intPreferencesKey("college_info")

val Preferences.launchInfo: LaunchInfo
    get() = LaunchInfo(
        college = this[COLLEGE_INFO],
        course = this[COURSE_INFO]
    )

fun MutablePreferences.setLaunchInfo(course: Int, college: Int) {
    this[COURSE_INFO] = course
    this[COLLEGE_INFO] = college
}

