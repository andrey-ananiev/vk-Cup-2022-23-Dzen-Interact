package ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop

import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset

class DragTargetInfo {
    var isDragging: Boolean by mutableStateOf(false)
    var dragOffset by mutableStateOf(Offset.Zero)
    var dragPosition = Offset.Zero //by mutableStateOf(Offset.Zero)
    var draggableComposable : (@Composable () -> Unit)? = null //by mutableStateOf<(@Composable () -> Unit)?>(null)
    var dataToDrop : Any? = null //by mutableStateOf<Any?>(null)
}