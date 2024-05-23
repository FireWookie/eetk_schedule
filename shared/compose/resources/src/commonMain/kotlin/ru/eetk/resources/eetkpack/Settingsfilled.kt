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

public val EETKPack.Settingsfilled: ImageVector
    get() {
        if (_settingsfilled != null) {
            return _settingsfilled!!
        }
        _settingsfilled = Builder(name = "Settingsfilled", defaultWidth = 19.0.dp, defaultHeight =
                20.0.dp, viewportWidth = 19.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(16.4736f, 10.9399f)
                curveTo(16.5136f, 10.6399f, 16.5336f, 10.3299f, 16.5336f, 9.9999f)
                curveTo(16.5336f, 9.6799f, 16.5136f, 9.3599f, 16.4636f, 9.0599f)
                lineTo(18.4936f, 7.4799f)
                curveTo(18.6736f, 7.3399f, 18.7236f, 7.0699f, 18.6136f, 6.8699f)
                lineTo(16.6936f, 3.5499f)
                curveTo(16.5736f, 3.3299f, 16.3236f, 3.2599f, 16.1036f, 3.3299f)
                lineTo(13.7136f, 4.2899f)
                curveTo(13.2136f, 3.9099f, 12.6836f, 3.5899f, 12.0936f, 3.3499f)
                lineTo(11.7336f, 0.8099f)
                curveTo(11.6936f, 0.5699f, 11.4936f, 0.3999f, 11.2536f, 0.3999f)
                horizontalLineTo(7.4136f)
                curveTo(7.1736f, 0.3999f, 6.9836f, 0.5699f, 6.9436f, 0.8099f)
                lineTo(6.5836f, 3.3499f)
                curveTo(5.9936f, 3.5899f, 5.4536f, 3.9199f, 4.9636f, 4.2899f)
                lineTo(2.5736f, 3.3299f)
                curveTo(2.3536f, 3.2499f, 2.1036f, 3.3299f, 1.9836f, 3.5499f)
                lineTo(0.0736f, 6.8699f)
                curveTo(-0.0464f, 7.0799f, -0.0064f, 7.3399f, 0.1936f, 7.4799f)
                lineTo(2.2236f, 9.0599f)
                curveTo(2.1736f, 9.3599f, 2.1336f, 9.6899f, 2.1336f, 9.9999f)
                curveTo(2.1336f, 10.3099f, 2.1536f, 10.6399f, 2.2036f, 10.9399f)
                lineTo(0.1736f, 12.5199f)
                curveTo(-0.0064f, 12.6599f, -0.0564f, 12.9299f, 0.0536f, 13.1299f)
                lineTo(1.9736f, 16.4499f)
                curveTo(2.0936f, 16.6699f, 2.3436f, 16.7399f, 2.5636f, 16.6699f)
                lineTo(4.9536f, 15.7099f)
                curveTo(5.4536f, 16.0899f, 5.9836f, 16.4099f, 6.5736f, 16.6499f)
                lineTo(6.9336f, 19.1899f)
                curveTo(6.9836f, 19.4299f, 7.1736f, 19.5999f, 7.4136f, 19.5999f)
                horizontalLineTo(11.2536f)
                curveTo(11.4936f, 19.5999f, 11.6936f, 19.4299f, 11.7236f, 19.1899f)
                lineTo(12.0836f, 16.6499f)
                curveTo(12.6736f, 16.4099f, 13.2136f, 16.0899f, 13.7036f, 15.7099f)
                lineTo(16.0936f, 16.6699f)
                curveTo(16.3136f, 16.7499f, 16.5636f, 16.6699f, 16.6836f, 16.4499f)
                lineTo(18.6036f, 13.1299f)
                curveTo(18.7236f, 12.9099f, 18.6736f, 12.6599f, 18.4836f, 12.5199f)
                lineTo(16.4736f, 10.9399f)
                close()
                moveTo(9.3336f, 13.5999f)
                curveTo(7.3536f, 13.5999f, 5.7336f, 11.9799f, 5.7336f, 9.9999f)
                curveTo(5.7336f, 8.0199f, 7.3536f, 6.3999f, 9.3336f, 6.3999f)
                curveTo(11.3136f, 6.3999f, 12.9336f, 8.0199f, 12.9336f, 9.9999f)
                curveTo(12.9336f, 11.9799f, 11.3136f, 13.5999f, 9.3336f, 13.5999f)
                close()
            }
        }
        .build()
        return _settingsfilled!!
    }

private var _settingsfilled: ImageVector? = null
