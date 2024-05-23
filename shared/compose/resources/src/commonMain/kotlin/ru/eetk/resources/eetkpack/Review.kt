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

public val EETKPack.Review: ImageVector
    get() {
        if (_review != null) {
            return _review!!
        }
        _review = Builder(name = "Review", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(12.0f, 15.0f)
                lineTo(13.55f, 11.55f)
                lineTo(17.0f, 10.0f)
                lineTo(13.55f, 8.45f)
                lineTo(12.0f, 5.0f)
                lineTo(10.45f, 8.45f)
                lineTo(7.0f, 10.0f)
                lineTo(10.45f, 11.55f)
                lineTo(12.0f, 15.0f)
                close()
                moveTo(2.0f, 22.0f)
                verticalLineTo(4.0f)
                curveTo(2.0f, 3.45f, 2.196f, 2.979f, 2.588f, 2.587f)
                curveTo(2.9793f, 2.1957f, 3.45f, 2.0f, 4.0f, 2.0f)
                horizontalLineTo(20.0f)
                curveTo(20.55f, 2.0f, 21.021f, 2.1957f, 21.413f, 2.587f)
                curveTo(21.8043f, 2.979f, 22.0f, 3.45f, 22.0f, 4.0f)
                verticalLineTo(16.0f)
                curveTo(22.0f, 16.55f, 21.8043f, 17.021f, 21.413f, 17.413f)
                curveTo(21.021f, 17.8043f, 20.55f, 18.0f, 20.0f, 18.0f)
                horizontalLineTo(6.0f)
                lineTo(2.0f, 22.0f)
                close()
                moveTo(4.0f, 17.175f)
                lineTo(5.175f, 16.0f)
                horizontalLineTo(20.0f)
                verticalLineTo(4.0f)
                horizontalLineTo(4.0f)
                verticalLineTo(17.175f)
                close()
            }
        }
        .build()
        return _review!!
    }

private var _review: ImageVector? = null
