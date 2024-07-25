package ru.eetk.schedule.root.component.utils

import androidx.compose.ui.graphics.vector.ImageVector
import dev.icerock.moko.resources.StringResource
import ru.eetk.resources.EETKPack
import ru.eetk.resources.EetkRes
import ru.eetk.resources.eetkpack.Review
import ru.eetk.resources.eetkpack.Reviewfilled
import ru.eetk.resources.eetkpack.Schedule
import ru.eetk.resources.eetkpack.Schedulefilled

internal sealed class Screen(
    val index: Int,
    val labelId: StringResource,
) {

    data object Schedule : Screen(
        index = 0,
        labelId = EetkRes.strings.schedule,
    )

    data object Changes : Screen(
        index = 1,
        labelId = EetkRes.strings.changes,
    )
}