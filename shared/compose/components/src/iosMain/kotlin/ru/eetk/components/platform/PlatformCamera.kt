package ru.eetk.components.platform

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material.icons.sharp.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.CValue
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCAction
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVCaptureDeviceDiscoverySession
import platform.AVFoundation.AVCaptureDeviceInput
import platform.AVFoundation.AVCaptureDevicePositionBack
import platform.AVFoundation.AVCaptureDeviceTypeBuiltInDualCamera
import platform.AVFoundation.AVCaptureDeviceTypeBuiltInDualWideCamera
import platform.AVFoundation.AVCaptureDeviceTypeBuiltInDuoCamera
import platform.AVFoundation.AVCaptureDeviceTypeBuiltInUltraWideCamera
import platform.AVFoundation.AVCaptureDeviceTypeBuiltInWideAngleCamera
import platform.AVFoundation.AVCapturePhoto
import platform.AVFoundation.AVCapturePhotoCaptureDelegateProtocol
import platform.AVFoundation.AVCapturePhotoOutput
import platform.AVFoundation.AVCapturePhotoSettings
import platform.AVFoundation.AVCaptureSession
import platform.AVFoundation.AVCaptureSessionPresetPhoto
import platform.AVFoundation.AVCaptureVideoOrientationLandscapeLeft
import platform.AVFoundation.AVCaptureVideoOrientationLandscapeRight
import platform.AVFoundation.AVCaptureVideoOrientationPortrait
import platform.AVFoundation.AVCaptureVideoPreviewLayer
import platform.AVFoundation.AVLayerVideoGravityResizeAspectFill
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.AVVideoCodecKey
import platform.AVFoundation.AVVideoCodecTypeJPEG
import platform.AVFoundation.fileDataRepresentation
import platform.AssetsLibrary.ALAssetOrientation
import platform.AssetsLibrary.ALAssetsLibrary
import platform.CoreGraphics.CGRect
import platform.Foundation.NSData
import platform.Foundation.NSError
import platform.Foundation.NSNotification
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSSelectorFromString
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIDevice
import platform.UIKit.UIDeviceOrientation
import platform.UIKit.UIDeviceOrientationDidChangeNotification
import platform.UIKit.UIImage
import platform.UIKit.UIImagePNGRepresentation
import platform.UIKit.UIView
import platform.darwin.NSObject
import platform.posix.memcpy

private val deviceTypes = listOf(
    AVCaptureDeviceTypeBuiltInWideAngleCamera,
    AVCaptureDeviceTypeBuiltInDualWideCamera,
    AVCaptureDeviceTypeBuiltInDualCamera,
    AVCaptureDeviceTypeBuiltInUltraWideCamera,
    AVCaptureDeviceTypeBuiltInDuoCamera
)

@OptIn(ExperimentalForeignApi::class)
private inline fun NSData.toByteArray(): ByteArray {
    val size = length.toInt()
    val byteArray = ByteArray(size)
    if (size > 0) {
        byteArray.usePinned { pinned ->
            memcpy(pinned.addressOf(0), this.bytes, this.length)
        }
    }
    return byteArray
}

@Composable
actual fun PlatformCamera(
    modifier: Modifier,
    onBack: () -> Unit,
    photo: (ByteArray) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AuthorizedCamera(photo, onBack)
    }

}


@Composable
private fun BoxScope.AuthorizedCamera(
    photo: (ByteArray) -> Unit,
    onBack: () -> Unit,
) {
    val camera: AVCaptureDevice? = remember {
        AVCaptureDeviceDiscoverySession.discoverySessionWithDeviceTypes(
            deviceTypes = deviceTypes,
            mediaType = AVMediaTypeVideo,
            position = AVCaptureDevicePositionBack,
        ).devices.firstOrNull() as? AVCaptureDevice
    }
    if (camera != null) {
        RealDeviceCamera(camera, photo, onBack)
    } else {
        Text(
            """
            Camera is not available on simulator.
            Please try to run on a real iOS device.
        """.trimIndent(), color = Color.White
        )
    }
}

@OptIn(ExperimentalForeignApi::class)
@Composable
private fun BoxScope.RealDeviceCamera(
    camera: AVCaptureDevice,
    photo: (ByteArray) -> Unit,
    onBack: () -> Unit,
) {
    val capturePhotoOutput = remember { AVCapturePhotoOutput() }
    var actualOrientation by remember {
        mutableStateOf(
            AVCaptureVideoOrientationPortrait
        )
    }

    var capturePhotoStarted by remember { mutableStateOf(false) }
    val photoCaptureDelegate = remember {
        object : NSObject(), AVCapturePhotoCaptureDelegateProtocol {
            override fun captureOutput(
                output: AVCapturePhotoOutput,
                didFinishProcessingPhoto: AVCapturePhoto,
                error: NSError?
            ) {
                val photoData = didFinishProcessingPhoto.fileDataRepresentation()
                if (photoData != null) {

                    val uiImage = UIImage(photoData)
                    val imageData = UIImagePNGRepresentation(uiImage)
                    val byteArray: ByteArray? = imageData?.toByteArray()
                    photo(byteArray!!)
//                    ALAssetsLibrary().writeImageToSavedPhotosAlbum(
//                        uiImage.CGImage,
//                        ALAssetOrientation.byValue(uiImage.imageOrientation.value)
//                    ) { url,error ->
//                        photo(url?.path.orEmpty())
//                    }

//
                }
                capturePhotoStarted = false
            }
        }
    }

    val captureSession: AVCaptureSession = remember {
        AVCaptureSession().also { captureSession ->
            captureSession.sessionPreset = AVCaptureSessionPresetPhoto
            val captureDeviceInput: AVCaptureDeviceInput =
                AVCaptureDeviceInput.deviceInputWithDevice(device = camera, error = null)!!
            captureSession.addInput(captureDeviceInput)
            captureSession.addOutput(capturePhotoOutput)
        }
    }
    val cameraPreviewLayer = remember {
        AVCaptureVideoPreviewLayer(session = captureSession)
    }

    DisposableEffect(Unit) {
        class OrientationListener : NSObject() {

            @Suppress("UNUSED_PARAMETER")
            @ObjCAction
            fun orientationDidChange(arg: NSNotification) {
                val cameraConnection = cameraPreviewLayer.connection
                if (cameraConnection != null) {
                    actualOrientation = when (UIDevice.currentDevice.orientation) {
                        UIDeviceOrientation.UIDeviceOrientationPortrait ->
                            AVCaptureVideoOrientationPortrait

                        UIDeviceOrientation.UIDeviceOrientationLandscapeLeft ->
                            AVCaptureVideoOrientationLandscapeRight

                        UIDeviceOrientation.UIDeviceOrientationLandscapeRight ->
                            AVCaptureVideoOrientationLandscapeLeft

                        UIDeviceOrientation.UIDeviceOrientationPortraitUpsideDown ->
                            AVCaptureVideoOrientationPortrait

                        else -> cameraConnection.videoOrientation
                    }
                    cameraConnection.videoOrientation = actualOrientation
                }
                capturePhotoOutput.connectionWithMediaType(AVMediaTypeVideo)
                    ?.videoOrientation = actualOrientation
            }
        }

        val listener = OrientationListener()
        val notificationName = UIDeviceOrientationDidChangeNotification
        NSNotificationCenter.defaultCenter.addObserver(
            observer = listener,
            selector = NSSelectorFromString(
                OrientationListener::orientationDidChange.name + ":"
            ),
            name = notificationName,
            `object` = null
        )
        onDispose {
            NSNotificationCenter.defaultCenter.removeObserver(
                observer = listener,
                name = notificationName,
                `object` = null
            )
        }
    }
    UIKitView(
        modifier = Modifier.fillMaxSize(),
        background = Color.Black,
        factory = {
            val cameraContainer = UIView()
            cameraContainer.layer.addSublayer(cameraPreviewLayer)
            cameraPreviewLayer.videoGravity = AVLayerVideoGravityResizeAspectFill
            captureSession.startRunning()
            cameraContainer
        },
        onResize = { view: UIView, rect: CValue<CGRect> ->
            CATransaction.begin()
            CATransaction.setValue(true, kCATransactionDisableActions)
            view.layer.setFrame(rect)
            cameraPreviewLayer.setFrame(rect)
            CATransaction.commit()
        },
    )
    IconButton(
        enabled = !capturePhotoStarted,
        modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp),
        onClick = {
            capturePhotoStarted = true
            val photoSettings = AVCapturePhotoSettings.photoSettingsWithFormat(
                format = mapOf(AVVideoCodecKey to AVVideoCodecTypeJPEG)
            )
//            if (camera.position == AVCaptureDevicePositionFront) {
//                capturePhotoOutput.connectionWithMediaType(AVMediaTypeVideo)
//                    ?.automaticallyAdjustsVideoMirroring = false
//                capturePhotoOutput.connectionWithMediaType(AVMediaTypeVideo)
//                    ?.videoMirrored = true
//            }
            capturePhotoOutput.capturePhotoWithSettings(
                settings = photoSettings,
                delegate = photoCaptureDelegate
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
        enabled = !capturePhotoStarted,
        modifier = Modifier
            .align(Alignment.TopStart)
            .padding(start = 20.dp)
            .systemBarsPadding(),
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

    if (capturePhotoStarted) {
        CircularProgressIndicator(
            modifier = Modifier.size(80.dp).align(Alignment.Center),
            color = Color.White.copy(alpha = 0.7f),
            strokeWidth = 8.dp,
        )
    }


}


