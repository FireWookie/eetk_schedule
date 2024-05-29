package ru.eetk.compose_sheets.common

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.withContext
import ru.eetk.compose_sheets.utils.BottomSheetContentComponent

/**
 * Обёртка над Material 3 ModalBottomSheet для отображения BottomSheetContentComponent.
 *
 * Работает как диалог - отображает Popup поверх всего приложения,
 * и не требует заворачивать в себя остальной контент.
 *
 * Основа для интеграции с любой навигацией - принимает на вход `State<BottomSheetContentComponent?>`,
 * без привязки к Decompose.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentModalBottomSheet(
    sheetContentComponentState: State<BottomSheetContentComponent?>,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberComponentModalBottomSheetState(sheetContentComponentState),
    key: String = "ComponentMBS",
    sheetMaxWidth: Dp = BottomSheetDefaults.SheetMaxWidth,
    shape: Shape = BottomSheetDefaults.ExpandedShape,
    containerColor: Color = BottomSheetDefaults.ContainerColor,
    contentColor: Color = contentColorFor(containerColor),
    tonalElevation: Dp = BottomSheetDefaults.Elevation,
    scrimColor: Color = BottomSheetDefaults.ScrimColor,
    dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    windowInsets: WindowInsets = bottomSheetWindowInsets(),
    properties: ModalBottomSheetProperties = ModalBottomSheetDefaults.properties(),
    content: @Composable (ColumnScope.(BottomSheetContentComponent) -> Unit),
) {
    val currentOnDismiss by rememberUpdatedState(onDismiss)

    // Текущее состояние BottomSheet.
    val sheetContentSlot: BottomSheetContentComponent? by sheetContentComponentState

    // Последнее запомненное состояние BottomSheet.
    // В отличие от состояния bottomSheet, мы обновляем это поле вручную.
    // Это нужно для того, чтобы при программном закрытии BottomSheet (navigation.dismiss())
    // содержимое BottomSheet не исчезало моментально из-за того, что bottomSheet.child
    // становится равен null.
    // В переменной latestChildInstance мы сохраняем последний активный Child компонент,
    // и зануляем его только тогда, когда отработает функция modalBottomSheetState.hide(),
    // то есть, скрытие ботомщита будет завершено
    var latestChildInstance: BottomSheetContentComponent? by remember {
        mutableStateOf(sheetContentComponentState.value)
    }

    // Запускаем эффект при изменении состояния слота навигации BottomSheet.
    LaunchedEffect(sheetContentSlot) {
        val instance = sheetContentComponentState.value

        if (instance == null) {
            // Если слот стал пустым (компонент удалился из навигации), то нужно скрыть ModalBottomSheet так,
            // чтобы во время анимации скрытия внутри BottomSheet отображалось
            // содержимое того компонента, который был удален.
            // Для этого мы сначала вызываем hide(), и только после этого зануляем latestChildInstance.
            try {
                log("$key: hide(): start, instance=null, latestChildInstance=$latestChildInstance")
                sheetState.hide()
                log("$key: hide(): finish, instance=null, latestChildInstance=$latestChildInstance")
            } catch (e: Exception) {
                // отмена корутины здесь ожидаемое событие (рекомпозиция и другие причины),
                // поэтому логируем не как нефатал, а просто как сообщение.
                log("$key: hide(): exception, instance=null, latestChildInstance=$latestChildInstance", e)
            } finally {
                withContext(NonCancellable) {
                    log("$key: hide(): latestChildInstance = null")
                    // если корутина, которая делает hide(), отменилась
                    // всё равно считаем скрытие успешным, и зануляем запомненный компонент
                    latestChildInstance = null
                }
            }
        } else {
            // Если компонент появился в слоте навигации, то запоминаем его для последующего скрытия,
            // и просто открываем BottomSheet, без дополнительных действий.
            latestChildInstance = instance
            try {
                log("$key: show(): start, instance=$instance")
                sheetState.show()
                log("$key: show(): finish, instance=$instance")
            } catch (e: Exception) {
                // отмена корутины здесь ожидаемое событие (рекомпозиция и другие причины),
                // поэтому логируем не как нефатал, а просто как сообщение.
                log("$key: show(): exception, instance=$instance", e)
            }
        }
    }

    // Наблюдение за состоянием UI ModalBottomSheet.
    // Если BottomSheet скрывается, сообщаем об этом компоненту-хосту,
    // чтобы он сделал dismiss, и убрал текущего Child из слота навигации.
    LaunchedEffect(sheetState, sheetContentSlot) {
        snapshotFlow { sheetState.isVisible }
            // Нас интересуют только изменения состояния
            .distinctUntilChanged()
            // При композиции мы получаем значение false для состояния Hidden и закрываем боттом шит.
            // Поэтому нам надо пропускать первое значение состояния, иначае при создании композиции
            // ChildSlotModalBottomSheetLayout сразу с контентом дилаога, мы сразу закрываем диалог.
            .drop(1)
            .collect { isVisible ->
                val instance = sheetContentComponentState.value
                log("$key: isVisible=$isVisible, instance=$instance")
                if (!isVisible) {
                    log("$key: currentOnDismiss(), instance=$instance")
                    currentOnDismiss()
                }
            }
    }

    val childInstance = latestChildInstance

    if (childInstance != null) {
        ModalBottomSheet(
            onDismissRequest = {
                // пока неясно, какую пользу можно извлечь из этого коллбека
                log("$key: onDismissRequest")
            },
            modifier = modifier,
            sheetState = sheetState,
            sheetMaxWidth = sheetMaxWidth,
            shape = shape,
            containerColor = containerColor,
            contentColor = contentColor,
            tonalElevation = tonalElevation,
            scrimColor = scrimColor,
            dragHandle = dragHandle,
            windowInsets = windowInsets,
            properties = properties,
            content = {
                content(childInstance)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun rememberComponentModalBottomSheetState(
    sheetContentComponentState: State<BottomSheetContentComponent?>,
): SheetState {
    return rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { sheetValue ->
            if (sheetValue == SheetValue.Hidden) {
                val instance = sheetContentComponentState.value
                instance?.bottomSheetContentState?.value?.isDismissAllowed ?: true
            } else {
                true
            }
        }
    )
}

private fun log(message: String, throwable: Throwable? = null) {
    if (throwable != null) {
        println("ComponentMBS" + message + throwable)
    } else {
        println("ComponentMBS" + message)
    }
}

/**
 * Мы хотим отображать затемнение BottomSheet на весь экран, edge-to-edge,
 * включая статус бар и панель навгиации.
 *
 * На API < 30 есть баг https://issuetracker.google.com/issues/290893168
 * Проблема в том, что WindowInsets нормально работает только начиная с Android 11 (SDK 30).
 *
 * https://medium.com/androiddevelopers/animating-your-keyboard-fb776a8fb66d
 *
 * Compat-реализация поддерживается только для основных компонентов вроде Activity, но не
 * поддерживается в Window, в котором открывается Material 3 BottomSheet.
 */
@Composable
fun bottomSheetWindowInsets(): WindowInsets {
    return WindowInsets(0.dp)
}