package ru.eetk.resources.eetkpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.eetk.resources.EETKPack

public val EETKPack.Schedule: ImageVector
    get() {
        if (_schedule != null) {
            return _schedule!!
        }
        _schedule = Builder(name = "Schedule", defaultWidth = 25.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(5.6667f, 22.0f)
                curveTo(5.1167f, 22.0f, 4.6458f, 21.8043f, 4.2537f, 21.413f)
                curveTo(3.8624f, 21.021f, 3.6667f, 20.55f, 3.6667f, 20.0f)
                verticalLineTo(6.0f)
                curveTo(3.6667f, 5.45f, 3.8624f, 4.9793f, 4.2537f, 4.588f)
                curveTo(4.6458f, 4.196f, 5.1167f, 4.0f, 5.6667f, 4.0f)
                horizontalLineTo(6.6667f)
                verticalLineTo(2.0f)
                horizontalLineTo(8.6667f)
                verticalLineTo(4.0f)
                horizontalLineTo(16.6667f)
                verticalLineTo(2.0f)
                horizontalLineTo(18.6667f)
                verticalLineTo(4.0f)
                horizontalLineTo(19.6667f)
                curveTo(20.2167f, 4.0f, 20.6877f, 4.196f, 21.0797f, 4.588f)
                curveTo(21.4711f, 4.9793f, 21.6667f, 5.45f, 21.6667f, 6.0f)
                verticalLineTo(20.0f)
                curveTo(21.6667f, 20.55f, 21.4711f, 21.021f, 21.0797f, 21.413f)
                curveTo(20.6877f, 21.8043f, 20.2167f, 22.0f, 19.6667f, 22.0f)
                horizontalLineTo(5.6667f)
                close()
                moveTo(5.6667f, 20.0f)
                horizontalLineTo(19.6667f)
                verticalLineTo(10.0f)
                horizontalLineTo(5.6667f)
                verticalLineTo(20.0f)
                close()
                moveTo(5.6667f, 8.0f)
                horizontalLineTo(19.6667f)
                verticalLineTo(6.0f)
                horizontalLineTo(5.6667f)
                verticalLineTo(8.0f)
                close()
            }
        }
        .build()
        return _schedule!!
    }

private var _schedule: ImageVector? = null
