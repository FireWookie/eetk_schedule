package ru.eetk.resources

import androidx.compose.ui.graphics.vector.ImageVector
import ru.eetk.resources.eetkpack.Close
import ru.eetk.resources.eetkpack.Info
import ru.eetk.resources.eetkpack.Notification
import ru.eetk.resources.eetkpack.Palette
import ru.eetk.resources.eetkpack.Person
import ru.eetk.resources.eetkpack.Review
import ru.eetk.resources.eetkpack.Reviewfilled
import ru.eetk.resources.eetkpack.Schedule
import ru.eetk.resources.eetkpack.Schedulefilled
import ru.eetk.resources.eetkpack.Settings
import ru.eetk.resources.eetkpack.Settingsfilled
import kotlin.collections.List as ____KtList

public object EETKPack

private var __AllIcons: ____KtList<ImageVector>? = null

public val EETKPack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Person, Reviewfilled, Review, Settings, Info, Palette, Close, Settingsfilled,
        Notification, Schedulefilled, Schedule)
    return __AllIcons!!
  }
