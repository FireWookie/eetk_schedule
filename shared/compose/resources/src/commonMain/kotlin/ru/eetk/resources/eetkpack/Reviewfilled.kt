package ru.eetk.resources.eetkpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.eetk.resources.EETKPack

public val EETKPack.Reviewfilled: ImageVector
    get() {
        if (_reviewfilled != null) {
            return _reviewfilled!!
        }
        _reviewfilled = Builder(name = "Reviewfilled", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(20.0f, 2.0f)
                    horizontalLineTo(4.0f)
                    curveTo(2.9f, 2.0f, 2.0f, 2.9f, 2.0f, 4.0f)
                    verticalLineTo(22.0f)
                    lineTo(6.0f, 18.0f)
                    horizontalLineTo(20.0f)
                    curveTo(21.1f, 18.0f, 22.0f, 17.1f, 22.0f, 16.0f)
                    verticalLineTo(4.0f)
                    curveTo(22.0f, 2.9f, 21.1f, 2.0f, 20.0f, 2.0f)
                    close()
                    moveTo(13.57f, 11.57f)
                    lineTo(12.0f, 15.0f)
                    lineTo(10.43f, 11.57f)
                    lineTo(7.0f, 10.0f)
                    lineTo(10.43f, 8.43f)
                    lineTo(12.0f, 5.0f)
                    lineTo(13.57f, 8.43f)
                    lineTo(17.0f, 10.0f)
                    lineTo(13.57f, 11.57f)
                    close()
                }
            }
        }
        .build()
        return _reviewfilled!!
    }

private var _reviewfilled: ImageVector? = null
