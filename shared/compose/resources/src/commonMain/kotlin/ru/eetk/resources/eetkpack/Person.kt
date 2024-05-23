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

public val EETKPack.Person: ImageVector
    get() {
        if (_person != null) {
            return _person!!
        }
        _person = Builder(name = "Person", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF53433F)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(10.0f, 9.9999f)
                    curveTo(11.8417f, 9.9999f, 13.3334f, 8.5083f, 13.3334f, 6.6666f)
                    curveTo(13.3334f, 4.8249f, 11.8417f, 3.3333f, 10.0f, 3.3333f)
                    curveTo(8.1584f, 3.3333f, 6.6667f, 4.8249f, 6.6667f, 6.6666f)
                    curveTo(6.6667f, 8.5083f, 8.1584f, 9.9999f, 10.0f, 9.9999f)
                    close()
                    moveTo(10.0f, 11.6666f)
                    curveTo(7.775f, 11.6666f, 3.3334f, 12.7833f, 3.3334f, 14.9999f)
                    verticalLineTo(16.6666f)
                    horizontalLineTo(16.6667f)
                    verticalLineTo(14.9999f)
                    curveTo(16.6667f, 12.7833f, 12.225f, 11.6666f, 10.0f, 11.6666f)
                    close()
                }
            }
        }
        .build()
        return _person!!
    }

private var _person: ImageVector? = null
