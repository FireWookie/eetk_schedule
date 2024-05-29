package ru.eetk.components.platform

import android.net.Uri
import android.webkit.MimeTypeMap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

data class AndroidFile(
	override val path: String,
	override val platformFile: Uri,
) : MPFile<Uri>


/**
 * Компонент для выбора файла на платформе Android.
 *
 * @param show Флаг, показывающий нужно ли отображать диалог выбора файла.
 * @param initialDirectory Начальная директория для выбора файла.
 * @param fileExtensions Список расширений файлов для фильтрации.
 * @param onFileSelected Callback функция для выбора файла.
 */

@Composable
public actual fun FilePicker(
	show: Boolean,
	initialDirectory: String?,
	fileExtensions: List<String>,
	onFileSelected: FileSelected
) {
	val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.OpenDocument()) { result ->
		if (result != null) {
			onFileSelected(AndroidFile(result.toString(), result))
		} else {
			onFileSelected(null)
		}
	}

	val mimeTypeMap = MimeTypeMap.getSingleton()
	val mimeTypes = if (fileExtensions.isNotEmpty()) {
		fileExtensions.mapNotNull { ext ->
			mimeTypeMap.getMimeTypeFromExtension(ext)
		}.toTypedArray()
	} else {
		emptyArray()
	}

	LaunchedEffect(show) {
		if (show) {
			launcher.launch(mimeTypes)
		}
	}
}