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

public val EETKPack.Schedulefilled: ImageVector
    get() {
        if (_schedulefilled != null) {
            return _schedulefilled!!
        }
        _schedulefilled = Builder(name = "Schedulefilled", defaultWidth = 25.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(5.6666f, 22.0f)
                curveTo(5.1166f, 22.0f, 4.6456f, 21.8043f, 4.2536f, 21.413f)
                curveTo(3.8623f, 21.021f, 3.6666f, 20.55f, 3.6666f, 20.0f)
                verticalLineTo(6.0f)
                curveTo(3.6666f, 5.45f, 3.8623f, 4.9793f, 4.2536f, 4.588f)
                curveTo(4.6456f, 4.196f, 5.1166f, 4.0f, 5.6666f, 4.0f)
                horizontalLineTo(6.6666f)
                verticalLineTo(2.975f)
                curveTo(6.6666f, 2.6917f, 6.7623f, 2.4583f, 6.9536f, 2.275f)
                curveTo(7.1456f, 2.0917f, 7.3833f, 2.0f, 7.6666f, 2.0f)
                curveTo(7.95f, 2.0f, 8.1876f, 2.0957f, 8.3796f, 2.287f)
                curveTo(8.571f, 2.479f, 8.6666f, 2.7167f, 8.6666f, 3.0f)
                verticalLineTo(4.0f)
                horizontalLineTo(16.6666f)
                verticalLineTo(2.975f)
                curveTo(16.6666f, 2.6917f, 16.7626f, 2.4583f, 16.9546f, 2.275f)
                curveTo(17.146f, 2.0917f, 17.3833f, 2.0f, 17.6666f, 2.0f)
                curveTo(17.95f, 2.0f, 18.1873f, 2.0957f, 18.3786f, 2.287f)
                curveTo(18.5706f, 2.479f, 18.6666f, 2.7167f, 18.6666f, 3.0f)
                verticalLineTo(4.0f)
                horizontalLineTo(19.6666f)
                curveTo(20.2166f, 4.0f, 20.6876f, 4.196f, 21.0796f, 4.588f)
                curveTo(21.471f, 4.9793f, 21.6666f, 5.45f, 21.6666f, 6.0f)
                verticalLineTo(20.0f)
                curveTo(21.6666f, 20.55f, 21.471f, 21.021f, 21.0796f, 21.413f)
                curveTo(20.6876f, 21.8043f, 20.2166f, 22.0f, 19.6666f, 22.0f)
                horizontalLineTo(5.6666f)
                close()
                moveTo(5.6666f, 20.0f)
                horizontalLineTo(19.6666f)
                verticalLineTo(10.0f)
                horizontalLineTo(5.6666f)
                verticalLineTo(20.0f)
                close()
            }
        }
        .build()
        return _schedulefilled!!
    }

private var _schedulefilled: ImageVector? = null
