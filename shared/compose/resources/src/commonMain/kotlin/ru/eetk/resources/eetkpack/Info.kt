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

public val EETKPack.Info: ImageVector
    get() {
        if (_info != null) {
            return _info!!
        }
        _info = Builder(name = "Info", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF53433F)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(9.1666f, 5.8334f)
                    horizontalLineTo(10.8333f)
                    verticalLineTo(7.5001f)
                    horizontalLineTo(9.1666f)
                    verticalLineTo(5.8334f)
                    close()
                    moveTo(9.1666f, 9.1667f)
                    horizontalLineTo(10.8333f)
                    verticalLineTo(14.1667f)
                    horizontalLineTo(9.1666f)
                    verticalLineTo(9.1667f)
                    close()
                    moveTo(10.0f, 1.6667f)
                    curveTo(5.4f, 1.6667f, 1.6666f, 5.4001f, 1.6666f, 10.0001f)
                    curveTo(1.6666f, 14.6001f, 5.4f, 18.3334f, 10.0f, 18.3334f)
                    curveTo(14.6f, 18.3334f, 18.3333f, 14.6001f, 18.3333f, 10.0001f)
                    curveTo(18.3333f, 5.4001f, 14.6f, 1.6667f, 10.0f, 1.6667f)
                    close()
                    moveTo(10.0f, 16.6667f)
                    curveTo(6.325f, 16.6667f, 3.3333f, 13.6751f, 3.3333f, 10.0001f)
                    curveTo(3.3333f, 6.3251f, 6.325f, 3.3334f, 10.0f, 3.3334f)
                    curveTo(13.675f, 3.3334f, 16.6666f, 6.3251f, 16.6666f, 10.0001f)
                    curveTo(16.6666f, 13.6751f, 13.675f, 16.6667f, 10.0f, 16.6667f)
                    close()
                }
            }
        }
        .build()
        return _info!!
    }

private var _info: ImageVector? = null
