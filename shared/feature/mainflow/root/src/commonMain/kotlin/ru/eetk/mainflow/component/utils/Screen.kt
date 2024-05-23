package ru.eetk.mainflow.component.utils

import androidx.compose.ui.graphics.vector.ImageVector
import eetk_app.shared.compose.resources.generated.resources.Res
import eetk_app.shared.compose.resources.generated.resources.review
import eetk_app.shared.compose.resources.generated.resources.schedule
import eetk_app.shared.compose.resources.generated.resources.settings
import org.jetbrains.compose.resources.StringResource
import ru.eetk.resources.EETKPack
import ru.eetk.resources.eetkpack.Review
import ru.eetk.resources.eetkpack.Reviewfilled
import ru.eetk.resources.eetkpack.Schedule
import ru.eetk.resources.eetkpack.Schedulefilled
import ru.eetk.resources.eetkpack.Settings
import ru.eetk.resources.eetkpack.Settingsfilled

internal sealed class Screen(
    val index: Int,
    val labelId: StringResource,
    val icon: ImageVector,
    val iconSelected: ImageVector
) {

    data object Schedule : Screen(
        index = 0,
        labelId = Res.string.schedule,
        icon = EETKPack.Schedule,
        iconSelected = EETKPack.Schedulefilled
    )

    data object Review : Screen(
        index = 1,
        labelId = Res.string.review,
        icon = EETKPack.Review,
        iconSelected = EETKPack.Reviewfilled
    )

    data object Settings : Screen(
        index = 2,
        labelId = Res.string.settings,
        icon = EETKPack.Settings,
        iconSelected = EETKPack.Settingsfilled
    )


}