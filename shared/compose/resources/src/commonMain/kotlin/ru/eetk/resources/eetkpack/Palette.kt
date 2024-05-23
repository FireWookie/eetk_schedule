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

public val EETKPack.Palette: ImageVector
    get() {
        if (_palette != null) {
            return _palette!!
        }
        _palette = Builder(name = "Palette", defaultWidth = 20.0.dp, defaultHeight = 20.0.dp,
                viewportWidth = 20.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFF53433F)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.0f, 18.3334f)
                curveTo(8.8611f, 18.3334f, 7.7847f, 18.1145f, 6.7708f, 17.6767f)
                curveTo(5.7569f, 17.2395f, 4.8716f, 16.6423f, 4.115f, 15.8851f)
                curveTo(3.3577f, 15.1284f, 2.7605f, 14.2431f, 2.3233f, 13.2292f)
                curveTo(1.8855f, 12.2154f, 1.6666f, 11.139f, 1.6666f, 10.0001f)
                curveTo(1.6666f, 8.8473f, 1.8922f, 7.764f, 2.3433f, 6.7501f)
                curveTo(2.795f, 5.7362f, 3.4063f, 4.8542f, 4.1775f, 4.1042f)
                curveTo(4.948f, 3.3542f, 5.8472f, 2.7604f, 6.875f, 2.3226f)
                curveTo(7.9027f, 1.8854f, 9.0f, 1.6667f, 10.1666f, 1.6667f)
                curveTo(11.2777f, 1.6667f, 12.3263f, 1.8579f, 13.3125f, 2.2401f)
                curveTo(14.2986f, 2.6218f, 15.163f, 3.1495f, 15.9058f, 3.8234f)
                curveTo(16.6491f, 4.4967f, 17.2394f, 5.2954f, 17.6766f, 6.2193f)
                curveTo(18.1144f, 7.1426f, 18.3333f, 8.139f, 18.3333f, 9.2084f)
                curveTo(18.3333f, 10.8056f, 17.8472f, 12.0312f, 16.875f, 12.8851f)
                curveTo(15.9027f, 13.7395f, 14.7222f, 14.1667f, 13.3333f, 14.1667f)
                horizontalLineTo(11.7916f)
                curveTo(11.6666f, 14.1667f, 11.58f, 14.2015f, 11.5316f, 14.2709f)
                curveTo(11.4827f, 14.3404f, 11.4583f, 14.4167f, 11.4583f, 14.5001f)
                curveTo(11.4583f, 14.6667f, 11.5625f, 14.9062f, 11.7708f, 15.2184f)
                curveTo(11.9791f, 15.5312f, 12.0833f, 15.889f, 12.0833f, 16.2917f)
                curveTo(12.0833f, 16.9862f, 11.8922f, 17.5001f, 11.51f, 17.8334f)
                curveTo(11.1283f, 18.1667f, 10.625f, 18.3334f, 10.0f, 18.3334f)
                close()
                moveTo(5.4166f, 10.8334f)
                curveTo(5.7777f, 10.8334f, 6.0764f, 10.7154f, 6.3125f, 10.4792f)
                curveTo(6.5486f, 10.2431f, 6.6666f, 9.9445f, 6.6666f, 9.5834f)
                curveTo(6.6666f, 9.2223f, 6.5486f, 8.9237f, 6.3125f, 8.6876f)
                curveTo(6.0764f, 8.4515f, 5.7777f, 8.3334f, 5.4166f, 8.3334f)
                curveTo(5.0555f, 8.3334f, 4.7569f, 8.4515f, 4.5208f, 8.6876f)
                curveTo(4.2847f, 8.9237f, 4.1666f, 9.2223f, 4.1666f, 9.5834f)
                curveTo(4.1666f, 9.9445f, 4.2847f, 10.2431f, 4.5208f, 10.4792f)
                curveTo(4.7569f, 10.7154f, 5.0555f, 10.8334f, 5.4166f, 10.8334f)
                close()
                moveTo(7.9166f, 7.5001f)
                curveTo(8.2777f, 7.5001f, 8.5764f, 7.382f, 8.8125f, 7.1459f)
                curveTo(9.0486f, 6.9098f, 9.1666f, 6.6112f, 9.1666f, 6.2501f)
                curveTo(9.1666f, 5.889f, 9.0486f, 5.5904f, 8.8125f, 5.3542f)
                curveTo(8.5764f, 5.1181f, 8.2777f, 5.0001f, 7.9166f, 5.0001f)
                curveTo(7.5555f, 5.0001f, 7.2569f, 5.1181f, 7.0208f, 5.3542f)
                curveTo(6.7847f, 5.5904f, 6.6666f, 5.889f, 6.6666f, 6.2501f)
                curveTo(6.6666f, 6.6112f, 6.7847f, 6.9098f, 7.0208f, 7.1459f)
                curveTo(7.2569f, 7.382f, 7.5555f, 7.5001f, 7.9166f, 7.5001f)
                close()
                moveTo(12.0833f, 7.5001f)
                curveTo(12.4444f, 7.5001f, 12.743f, 7.382f, 12.9791f, 7.1459f)
                curveTo(13.2152f, 6.9098f, 13.3333f, 6.6112f, 13.3333f, 6.2501f)
                curveTo(13.3333f, 5.889f, 13.2152f, 5.5904f, 12.9791f, 5.3542f)
                curveTo(12.743f, 5.1181f, 12.4444f, 5.0001f, 12.0833f, 5.0001f)
                curveTo(11.7222f, 5.0001f, 11.4236f, 5.1181f, 11.1875f, 5.3542f)
                curveTo(10.9513f, 5.5904f, 10.8333f, 5.889f, 10.8333f, 6.2501f)
                curveTo(10.8333f, 6.6112f, 10.9513f, 6.9098f, 11.1875f, 7.1459f)
                curveTo(11.4236f, 7.382f, 11.7222f, 7.5001f, 12.0833f, 7.5001f)
                close()
                moveTo(14.5833f, 10.8334f)
                curveTo(14.9444f, 10.8334f, 15.243f, 10.7154f, 15.4791f, 10.4792f)
                curveTo(15.7152f, 10.2431f, 15.8333f, 9.9445f, 15.8333f, 9.5834f)
                curveTo(15.8333f, 9.2223f, 15.7152f, 8.9237f, 15.4791f, 8.6876f)
                curveTo(15.243f, 8.4515f, 14.9444f, 8.3334f, 14.5833f, 8.3334f)
                curveTo(14.2222f, 8.3334f, 13.9236f, 8.4515f, 13.6875f, 8.6876f)
                curveTo(13.4513f, 8.9237f, 13.3333f, 9.2223f, 13.3333f, 9.5834f)
                curveTo(13.3333f, 9.9445f, 13.4513f, 10.2431f, 13.6875f, 10.4792f)
                curveTo(13.9236f, 10.7154f, 14.2222f, 10.8334f, 14.5833f, 10.8334f)
                close()
                moveTo(10.0f, 16.6667f)
                curveTo(10.125f, 16.6667f, 10.2258f, 16.632f, 10.3025f, 16.5626f)
                curveTo(10.3786f, 16.4931f, 10.4166f, 16.4029f, 10.4166f, 16.2917f)
                curveTo(10.4166f, 16.0973f, 10.3125f, 15.8681f, 10.1041f, 15.6042f)
                curveTo(9.8958f, 15.3404f, 9.7916f, 14.9445f, 9.7916f, 14.4167f)
                curveTo(9.7916f, 13.8334f, 9.993f, 13.3681f, 10.3958f, 13.0209f)
                curveTo(10.7986f, 12.6737f, 11.2916f, 12.5001f, 11.875f, 12.5001f)
                horizontalLineTo(13.3333f)
                curveTo(14.25f, 12.5001f, 15.0347f, 12.2326f, 15.6875f, 11.6976f)
                curveTo(16.3402f, 11.1631f, 16.6666f, 10.3334f, 16.6666f, 9.2084f)
                curveTo(16.6666f, 7.5279f, 16.0244f, 6.1284f, 14.74f, 5.0101f)
                curveTo(13.455f, 3.8923f, 11.9305f, 3.3334f, 10.1666f, 3.3334f)
                curveTo(8.2777f, 3.3334f, 6.6666f, 3.9792f, 5.3333f, 5.2709f)
                curveTo(4.0f, 6.5626f, 3.3333f, 8.139f, 3.3333f, 10.0001f)
                curveTo(3.3333f, 11.8473f, 3.9827f, 13.4204f, 5.2816f, 14.7192f)
                curveTo(6.58f, 16.0176f, 8.1527f, 16.6667f, 10.0f, 16.6667f)
                close()
            }
        }
        .build()
        return _palette!!
    }

private var _palette: ImageVector? = null
