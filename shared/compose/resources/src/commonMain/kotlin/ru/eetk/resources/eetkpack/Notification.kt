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

public val EETKPack.Notification: ImageVector
    get() {
        if (_notification != null) {
            return _notification!!
        }
        _notification = Builder(name = "Notification", defaultWidth = 14.0.dp, defaultHeight =
                17.0.dp, viewportWidth = 14.0f, viewportHeight = 17.0f).apply {
            path(fill = SolidColor(Color(0xFF53433F)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(7.0f, 16.3333f)
                curveTo(7.9167f, 16.3333f, 8.6667f, 15.5833f, 8.6667f, 14.6666f)
                horizontalLineTo(5.3334f)
                curveTo(5.3334f, 15.5833f, 6.0834f, 16.3333f, 7.0f, 16.3333f)
                close()
                moveTo(12.0f, 11.3333f)
                verticalLineTo(7.1666f)
                curveTo(12.0f, 4.6083f, 10.6417f, 2.4666f, 8.25f, 1.8999f)
                verticalLineTo(1.3333f)
                curveTo(8.25f, 0.6416f, 7.6917f, 0.0833f, 7.0f, 0.0833f)
                curveTo(6.3084f, 0.0833f, 5.75f, 0.6416f, 5.75f, 1.3333f)
                verticalLineTo(1.8999f)
                curveTo(3.3667f, 2.4666f, 2.0f, 4.5999f, 2.0f, 7.1666f)
                verticalLineTo(11.3333f)
                lineTo(0.3334f, 12.9999f)
                verticalLineTo(13.8333f)
                horizontalLineTo(13.6667f)
                verticalLineTo(12.9999f)
                lineTo(12.0f, 11.3333f)
                close()
                moveTo(10.3334f, 12.1666f)
                horizontalLineTo(3.6667f)
                verticalLineTo(7.1666f)
                curveTo(3.6667f, 5.0999f, 4.925f, 3.4166f, 7.0f, 3.4166f)
                curveTo(9.075f, 3.4166f, 10.3334f, 5.0999f, 10.3334f, 7.1666f)
                verticalLineTo(12.1666f)
                close()
            }
        }
        .build()
        return _notification!!
    }

private var _notification: ImageVector? = null
