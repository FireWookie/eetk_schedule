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

public val EETKPack.Settings: ImageVector
    get() {
        if (_settings != null) {
            return _settings!!
        }
        _settings = Builder(name = "Settings", defaultWidth = 25.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(19.7636f, 12.98f)
                    curveTo(19.8036f, 12.66f, 19.8336f, 12.34f, 19.8336f, 12.0f)
                    curveTo(19.8336f, 11.66f, 19.8036f, 11.34f, 19.7636f, 11.02f)
                    lineTo(21.8736f, 9.37f)
                    curveTo(22.0636f, 9.22f, 22.1136f, 8.95f, 21.9936f, 8.73f)
                    lineTo(19.9936f, 5.27f)
                    curveTo(19.9036f, 5.11f, 19.7336f, 5.02f, 19.5536f, 5.02f)
                    curveTo(19.4936f, 5.02f, 19.4336f, 5.03f, 19.3836f, 5.05f)
                    lineTo(16.8936f, 6.05f)
                    curveTo(16.3736f, 5.65f, 15.8136f, 5.32f, 15.2036f, 5.07f)
                    lineTo(14.8236f, 2.42f)
                    curveTo(14.7936f, 2.18f, 14.5836f, 2.0f, 14.3336f, 2.0f)
                    horizontalLineTo(10.3336f)
                    curveTo(10.0836f, 2.0f, 9.8736f, 2.18f, 9.8436f, 2.42f)
                    lineTo(9.4636f, 5.07f)
                    curveTo(8.8536f, 5.32f, 8.2936f, 5.66f, 7.7736f, 6.05f)
                    lineTo(5.2836f, 5.05f)
                    curveTo(5.2236f, 5.03f, 5.1636f, 5.02f, 5.1036f, 5.02f)
                    curveTo(4.9336f, 5.02f, 4.7636f, 5.11f, 4.6736f, 5.27f)
                    lineTo(2.6736f, 8.73f)
                    curveTo(2.5436f, 8.95f, 2.6036f, 9.22f, 2.7936f, 9.37f)
                    lineTo(4.9036f, 11.02f)
                    curveTo(4.8636f, 11.34f, 4.8336f, 11.67f, 4.8336f, 12.0f)
                    curveTo(4.8336f, 12.33f, 4.8636f, 12.66f, 4.9036f, 12.98f)
                    lineTo(2.7936f, 14.63f)
                    curveTo(2.6036f, 14.78f, 2.5536f, 15.05f, 2.6736f, 15.27f)
                    lineTo(4.6736f, 18.73f)
                    curveTo(4.7636f, 18.89f, 4.9336f, 18.98f, 5.1136f, 18.98f)
                    curveTo(5.1736f, 18.98f, 5.2336f, 18.97f, 5.2836f, 18.95f)
                    lineTo(7.7736f, 17.95f)
                    curveTo(8.2936f, 18.35f, 8.8536f, 18.68f, 9.4636f, 18.93f)
                    lineTo(9.8436f, 21.58f)
                    curveTo(9.8736f, 21.82f, 10.0836f, 22.0f, 10.3336f, 22.0f)
                    horizontalLineTo(14.3336f)
                    curveTo(14.5836f, 22.0f, 14.7936f, 21.82f, 14.8236f, 21.58f)
                    lineTo(15.2036f, 18.93f)
                    curveTo(15.8136f, 18.68f, 16.3736f, 18.34f, 16.8936f, 17.95f)
                    lineTo(19.3836f, 18.95f)
                    curveTo(19.4436f, 18.97f, 19.5036f, 18.98f, 19.5636f, 18.98f)
                    curveTo(19.7336f, 18.98f, 19.9036f, 18.89f, 19.9936f, 18.73f)
                    lineTo(21.9936f, 15.27f)
                    curveTo(22.1136f, 15.05f, 22.0636f, 14.78f, 21.8736f, 14.63f)
                    lineTo(19.7636f, 12.98f)
                    close()
                    moveTo(17.7836f, 11.27f)
                    curveTo(17.8236f, 11.58f, 17.8336f, 11.79f, 17.8336f, 12.0f)
                    curveTo(17.8336f, 12.21f, 17.8136f, 12.43f, 17.7836f, 12.73f)
                    lineTo(17.6436f, 13.86f)
                    lineTo(18.5336f, 14.56f)
                    lineTo(19.6136f, 15.4f)
                    lineTo(18.9136f, 16.61f)
                    lineTo(17.6436f, 16.1f)
                    lineTo(16.6036f, 15.68f)
                    lineTo(15.7036f, 16.36f)
                    curveTo(15.2736f, 16.68f, 14.8636f, 16.92f, 14.4536f, 17.09f)
                    lineTo(13.3936f, 17.52f)
                    lineTo(13.2336f, 18.65f)
                    lineTo(13.0336f, 20.0f)
                    horizontalLineTo(11.6336f)
                    lineTo(11.4436f, 18.65f)
                    lineTo(11.2836f, 17.52f)
                    lineTo(10.2236f, 17.09f)
                    curveTo(9.7936f, 16.91f, 9.3936f, 16.68f, 8.9936f, 16.38f)
                    lineTo(8.0836f, 15.68f)
                    lineTo(7.0236f, 16.11f)
                    lineTo(5.7536f, 16.62f)
                    lineTo(5.0536f, 15.41f)
                    lineTo(6.1336f, 14.57f)
                    lineTo(7.0236f, 13.87f)
                    lineTo(6.8836f, 12.74f)
                    curveTo(6.8536f, 12.43f, 6.8336f, 12.2f, 6.8336f, 12.0f)
                    curveTo(6.8336f, 11.8f, 6.8536f, 11.57f, 6.8836f, 11.27f)
                    lineTo(7.0236f, 10.14f)
                    lineTo(6.1336f, 9.44f)
                    lineTo(5.0536f, 8.6f)
                    lineTo(5.7536f, 7.39f)
                    lineTo(7.0236f, 7.9f)
                    lineTo(8.0636f, 8.32f)
                    lineTo(8.9636f, 7.64f)
                    curveTo(9.3936f, 7.32f, 9.8036f, 7.08f, 10.2136f, 6.91f)
                    lineTo(11.2736f, 6.48f)
                    lineTo(11.4336f, 5.35f)
                    lineTo(11.6336f, 4.0f)
                    horizontalLineTo(13.0236f)
                    lineTo(13.2136f, 5.35f)
                    lineTo(13.3736f, 6.48f)
                    lineTo(14.4336f, 6.91f)
                    curveTo(14.8636f, 7.09f, 15.2636f, 7.32f, 15.6636f, 7.62f)
                    lineTo(16.5736f, 8.32f)
                    lineTo(17.6336f, 7.89f)
                    lineTo(18.9036f, 7.38f)
                    lineTo(19.6036f, 8.59f)
                    lineTo(18.5336f, 9.44f)
                    lineTo(17.6436f, 10.14f)
                    lineTo(17.7836f, 11.27f)
                    close()
                    moveTo(12.3336f, 8.0f)
                    curveTo(10.1236f, 8.0f, 8.3336f, 9.79f, 8.3336f, 12.0f)
                    curveTo(8.3336f, 14.21f, 10.1236f, 16.0f, 12.3336f, 16.0f)
                    curveTo(14.5436f, 16.0f, 16.3336f, 14.21f, 16.3336f, 12.0f)
                    curveTo(16.3336f, 9.79f, 14.5436f, 8.0f, 12.3336f, 8.0f)
                    close()
                    moveTo(12.3336f, 14.0f)
                    curveTo(11.2336f, 14.0f, 10.3336f, 13.1f, 10.3336f, 12.0f)
                    curveTo(10.3336f, 10.9f, 11.2336f, 10.0f, 12.3336f, 10.0f)
                    curveTo(13.4336f, 10.0f, 14.3336f, 10.9f, 14.3336f, 12.0f)
                    curveTo(14.3336f, 13.1f, 13.4336f, 14.0f, 12.3336f, 14.0f)
                    close()
                }
            }
        }
        .build()
        return _settings!!
    }

private var _settings: ImageVector? = null
