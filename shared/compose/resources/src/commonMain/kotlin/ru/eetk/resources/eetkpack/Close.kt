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

public val EETKPack.Close: ImageVector
    get() {
        if (_close != null) {
            return _close!!
        }
        _close = Builder(name = "Close", defaultWidth = 15.0.dp, defaultHeight = 15.0.dp,
                viewportWidth = 15.0f, viewportHeight = 15.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(14.5f, 1.91f)
                lineTo(13.09f, 0.5f)
                lineTo(7.5f, 6.09f)
                lineTo(1.91f, 0.5f)
                lineTo(0.5f, 1.91f)
                lineTo(6.09f, 7.5f)
                lineTo(0.5f, 13.09f)
                lineTo(1.91f, 14.5f)
                lineTo(7.5f, 8.91f)
                lineTo(13.09f, 14.5f)
                lineTo(14.5f, 13.09f)
                lineTo(8.91f, 7.5f)
                lineTo(14.5f, 1.91f)
                close()
            }
        }
        .build()
        return _close!!
    }

private var _close: ImageVector? = null
