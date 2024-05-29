package ru.eetk.components.platform

import ru.eetk.components.platform.FilePickerLauncher.Mode.Directory
import ru.eetk.components.platform.FilePickerLauncher.Mode.File
import platform.Foundation.NSURL
import platform.UIKit.UIAdaptivePresentationControllerDelegateProtocol
import platform.UIKit.UIApplication
import platform.UIKit.UIDocumentPickerDelegateProtocol
import platform.UIKit.UIDocumentPickerViewController
import platform.UIKit.UIPresentationController
import platform.UniformTypeIdentifiers.UTType
import platform.UniformTypeIdentifiers.UTTypeContent
import platform.UniformTypeIdentifiers.UTTypeFolder
import platform.darwin.NSObject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.native.concurrent.ThreadLocal

/**
 * Wraps platform specific implementation for launching a
 * File Picker.
 *
 * @param initialDirectory Initial directory that the
 *  file picker should open to.
 * @param pickerMode [Mode] to open the picker with.
 *
 */
class FilePickerLauncher(
	private val initialDirectory: String?,
	private val pickerMode: Mode,
	private val onFileSelected: FileSelected,
) {

	@ThreadLocal
	public companion object {
		/**
		 * For use only with launching plain (no compose dependencies)
		 * file picker. When a function completes iOS deallocates
		 * unreferenced objects created within it, so we need to
		 * keep a reference of the active launcher.
		 */
		internal var activeLauncher: FilePickerLauncher? = null
	}

	/**
	 * Identifies the kind of file picker to open. Either
	 * [Directory] or [File].
	 */
	public sealed interface Mode {
		/**
		 * Use this mode to open a [FilePickerLauncher] for selecting
		 * folders/directories.
		 */
		public data object Directory : Mode

		/**
		 * Use this mode to open a [FilePickerLauncher] for selecting
		 * files.
		 *
		 * @param extensions List of file extensions that can be
		 *  selected on this file picker.
		 */
		public data class File(val extensions: List<String>) : Mode
	}

	private val pickerDelegate = object : NSObject(),
		UIDocumentPickerDelegateProtocol,
		UIAdaptivePresentationControllerDelegateProtocol {

		override fun documentPicker(
			controller: UIDocumentPickerViewController, didPickDocumentsAtURLs: List<*>
		) {
			(didPickDocumentsAtURLs.firstOrNull() as? NSURL).let { selected ->
				onFileSelected(selected?.path?.let { IosFile(it, selected) })
			}
		}

		override fun documentPickerWasCancelled(
			controller: UIDocumentPickerViewController
		) {
			onFileSelected(null)
		}

		override fun presentationControllerWillDismiss(
			presentationController: UIPresentationController
		) {
			(presentationController.presentedViewController as? UIDocumentPickerViewController)
				?.let { documentPickerWasCancelled(it) }
		}
	}

	private val contentTypes: List<UTType>
		get() = when (pickerMode) {
			is Directory -> listOf(UTTypeFolder)
			is File -> pickerMode.extensions
				.mapNotNull { UTType.typeWithFilenameExtension(it) }
				.ifEmpty { listOf(UTTypeContent) }
		}

	private fun createPicker() = UIDocumentPickerViewController(
		forOpeningContentTypes = contentTypes
	).apply {
		delegate = pickerDelegate
		initialDirectory?.let { directoryURL = NSURL(string = it) }
	}

	public fun launchFilePicker() {
		activeLauncher = this

		UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
			// Reusing a closed/dismissed picker causes problems with
			// triggering delegate functions, launch with a new one.
			createPicker(),
			animated = true,
			completion = null
		)
	}
}

public suspend fun launchFilePicker(
	initialDirectory: String? = null,
	fileExtensions: List<String>,
): List<MPFile<Any>> = suspendCoroutine { cont ->
	try {
		FilePickerLauncher(
			initialDirectory = initialDirectory,
			pickerMode = File(fileExtensions),
			onFileSelected = { selected ->
				// File selection has ended, no launcher is active anymore
				// dereference it
				FilePickerLauncher.activeLauncher = null
				cont.resume(selected?.let { listOf(it) }.orEmpty())
			}
		).also { launcher ->
			// We're showing the file picker at this time so we set
			// the activeLauncher here. This might be the last time
			// there's an outside reference to the file picker.
			FilePickerLauncher.activeLauncher = launcher
			launcher.launchFilePicker()
		}
	} catch (e: Throwable) {
		// don't swallow errors
		cont.resumeWithException(e)
	}
}

public suspend fun launchDirectoryPicker(
	initialDirectory: String? = null,
): List<MPFile<Any>> = suspendCoroutine { cont ->
	try {
		FilePickerLauncher(
			initialDirectory = initialDirectory,
			pickerMode = Directory,
			onFileSelected = { selected ->
				// File selection has ended, no launcher is active anymore
				// dereference it
				FilePickerLauncher.activeLauncher = null
				cont.resume(selected?.let { listOf(it) }.orEmpty())
			},
		).also { launcher ->
			// We're showing the file picker at this time so we set
			// the activeLauncher here. This might be the last time
			// there's an outside reference to the file picker.
			FilePickerLauncher.activeLauncher = launcher
			launcher.launchFilePicker()
		}
	} catch (e: Throwable) {
		cont.resumeWithException(e)
	}
}