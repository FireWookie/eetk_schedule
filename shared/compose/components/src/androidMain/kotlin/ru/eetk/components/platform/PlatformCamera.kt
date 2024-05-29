package ru.eetk.components.platform

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.view.ViewGroup
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCapture.OnImageCapturedCallback
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.File
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.Executor
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


private suspend fun Context.getCameraProvider(): ProcessCameraProvider =
    suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(this).also { cameraProvider ->
            cameraProvider.addListener({
                continuation.resume(cameraProvider.get())
            }, executor)
        }
    }


private val Context.executor: Executor
    get() = ContextCompat.getMainExecutor(this)


/**
 *  @param fileNameFormat Формат имени файла.
 *  @param imageCapture Объект ImageCapture для захвата фотографии.
 *  @param outputDirectory Директория для сохранения изображения.
 *  @param executor Исполнитель для выполнения асинхронных операций.
 *  @param onImageCaptured Callback-функция, вызываемая при успешном захвате изображения.
 *  @param onError Callback-функция, вызываемая при ошибке захвата изображения.
 */

private fun takePhoto(
    fileNameFormat: String,
    imageCapture: ImageCapture,
    outputDirectory: File,
    executor: Executor,
    onImageCaptured: (ByteArray?) -> Unit,
    onError: (ImageCaptureException) -> Unit,
) {

    val photoFile = File(
        outputDirectory,
        SimpleDateFormat(fileNameFormat, Locale.US).format(System.currentTimeMillis()) + ".jpg"
    )

    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

    class ImageCaptureCallback(
        val onCapture: (byteArray: ByteArray?) -> Unit
    ): OnImageCapturedCallback() {
        override fun onCaptureSuccess(image: ImageProxy) {
            val imageBytes = image.toByteArray()
            onCapture(imageBytes)
        }
    }

    imageCapture.takePicture(executor, ImageCaptureCallback(onImageCaptured))
}

/**
 * Получает директорию для сохранения выходного файла.
 * @return Директория для сохранения файлов.
 */
private fun Context.getOutputDirectory(): File {
    val mediaDir = externalCacheDirs.firstOrNull()?.let {
        File(it, "eetk_app").apply { mkdirs() }
    }

    return if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
}

@Composable
actual fun PlatformCamera(
    modifier: Modifier,
    onBack: () -> Unit,
    photo: (ByteArray) -> Unit
) {

    val scaleType: PreviewView.ScaleType = PreviewView.ScaleType.FILL_CENTER
    val cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
    val imageCapture: ImageCapture = remember { ImageCapture.Builder().build() }

    val coroutineScope = rememberCoroutineScope()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    Box(contentAlignment = Alignment.BottomCenter, modifier = modifier) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                val previewView = PreviewView(context).apply {
                    this.scaleType = scaleType
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }

                // CameraX Preview UseCase
                val previewUseCase = Preview.Builder()
                    .build()
                    .also {
                        it.setSurfaceProvider(previewView.surfaceProvider)
                    }

                coroutineScope.launch {
                    val cameraProvider = context.getCameraProvider()
                    try {
                        // Must unbind the use-cases before rebinding them.
                        cameraProvider.unbindAll()
                        cameraProvider.bindToLifecycle(
                            lifecycleOwner, cameraSelector, previewUseCase, imageCapture
                        )
                    } catch (ex: Exception) {
                        println(ex)
                    }
                }

                previewView
            }
        )

        IconButton(
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp),
            onClick = {
                takePhoto(
                    fileNameFormat = "yyyy-MM-dd-HH-mm-ss-SSS",
                    imageCapture = imageCapture,
                    outputDirectory = context.getOutputDirectory(),
                    executor = context.executor,
                    onImageCaptured = {
                        photo(it!!)
                    },
                    onError = {
                        println()
                    }
                )
            },
            content = {
                Icon(
                    imageVector = Icons.Sharp.Close,
                    contentDescription = "Take picture",
                    tint = Color.White,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(1.dp)
                        .border(1.dp, Color.White, CircleShape)
                )
            }
        )

        IconButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 20.dp),
            onClick = onBack,
            content = {
                Icon(
                    imageVector = Icons.Sharp.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(1.dp)
                )
            }
        )
    }
}

private fun ImageProxy.toByteArray(): ByteArray {
    val rotationDegrees = imageInfo.rotationDegrees
    val bitmap = toBitmap()

    // Rotate the image if necessary
    val rotatedData = bitmap.toByteArray()
    close()

    return rotatedData
}

private fun Bitmap.toByteArray(): ByteArray {
    val stream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.JPEG, 100, stream)
    return stream.toByteArray()
}
