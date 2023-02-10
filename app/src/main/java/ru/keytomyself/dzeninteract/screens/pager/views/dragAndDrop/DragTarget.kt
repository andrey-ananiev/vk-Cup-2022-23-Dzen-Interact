package ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop

import android.util.Log
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned

internal val LocalDragTargetInfo = compositionLocalOf { DragTargetInfo() }

@Composable
fun <T> DragTarget(
    modifier: Modifier,
    dataToDrop: T,
    content: @Composable (() -> Unit)
) {
    var currentPosition by remember { mutableStateOf(Offset.Zero) }
    val currentState = LocalDragTargetInfo.current

    Box(modifier = modifier
        .onGloballyPositioned {
            currentPosition = it.localToWindow(Offset.Zero)
        }
        .pointerInput(dataToDrop) {
             detectDragGestures(
                 onDragStart = {
                     currentState.dataToDrop = dataToDrop
                     currentState.isDragging = true
                     currentState.dragPosition = currentPosition + it
                     currentState.draggableComposable = content
                 },
                 onDrag = { change, dragAmount ->
                     change.consume()
                     currentState.dragOffset += Offset(dragAmount.x, dragAmount.y)
                 },
                 onDragEnd = {
                     currentState.isDragging = false
                     currentState.dragOffset = Offset.Zero
                     currentState.dragPosition = Offset.Zero
                 },
                 onDragCancel = {
                     currentState.dragOffset = Offset.Zero
                     currentState.dragPosition = Offset.Zero
                     currentState.isDragging = false
                 }
             )
        }) {
        content()
    }
}