package ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.math.abs

class DragInfo(initialIndex: Int) {

    var index by mutableStateOf(initialIndex)
    var isDragging: Boolean by mutableStateOf(false)
    var dragOffset by mutableStateOf(0F)
    var offsetAnim by mutableStateOf(0F)
}

val GlobalDragInfo = compositionLocalOf { DragInfo(-1) }

@Composable
fun <T> DragForSwap(
    itemList: List<T>,
    orientation: Orientation,
    itemSize: Int,
    onLetterReplaced: (Int, Boolean) -> Unit,
    itemContent: @Composable ((Modifier, Int, T) -> Unit)
) {
    val boxSize = itemList.size * itemSize
    val boxModifier = if (orientation == Orientation.Vertical) Modifier.height(boxSize.dp)
    else Modifier.width(boxSize.dp)

    Box(modifier = boxModifier
    ) {
        itemList.forEachIndexed { index, item ->

            val scope = rememberCoroutineScope()
            val currentState by remember { mutableStateOf(DragInfo(index)) }
            val dragState  = GlobalDragInfo.current
            val offsetAnim = remember { Animatable(0F) }
            val currentPosition = currentState.index * itemSize + currentState.dragOffset + offsetAnim.value
            val dragPosition = dragState.index * itemSize + dragState.dragOffset + dragState.offsetAnim
            val isDrag = !currentState.isDragging && dragState.isDragging

            val itemModifier = Modifier
                .padding(12.dp)
                .align(Alignment.TopStart)
                .offset(
                    x = if (orientation == Orientation.Horizontal) currentPosition.dp else 0.dp,
                    y = if (orientation == Orientation.Vertical) currentPosition.dp else 0.dp
                )
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragStart = {
                            currentState.isDragging = true
                            dragState.isDragging = true
                            dragState.index = currentState.index
                            dragState.dragOffset = currentState.dragOffset
                            dragState.offsetAnim = offsetAnim.value
                        },
                        onDrag = { change, dragAmount ->
                            change.consume()
                            val pos = currentState.index * itemSize + currentState.dragOffset + offsetAnim.value
                            val amount = if (orientation == Orientation.Vertical) dragAmount.y else dragAmount.x
                            if (pos > -itemSize * 0.1 && pos <= boxSize - itemSize * 0.9) {

                                currentState.dragOffset += amount / density
                                dragState.dragOffset += amount / density
                            }
                        },
                        onDragEnd = {
                            currentState.isDragging = false
                            dragState.isDragging = false

                            scope.launch {
                                var target =
                                    (currentState.dragOffset + offsetAnim.value) % itemSize
                                if (abs(target) > itemSize / 2)
                                    if (target < 0) target += itemSize else target -= itemSize
                                target = offsetAnim.value - target
                                offsetAnim.animateTo(
                                    targetValue = target,
                                    animationSpec = tween(durationMillis = 100)
                                )
                            }
                        },
                        onDragCancel = {
                            currentState.isDragging = false
                            dragState.isDragging = false
                        }
                    )
                }
                .onGloballyPositioned {
                    val dragDistance = currentPosition - dragPosition
                    val isContainDrag =
                        isDrag && abs(dragDistance) < itemSize / 2 && !offsetAnim.isRunning
                    if (isContainDrag) scope.launch {
                        onLetterReplaced(index, dragDistance < 0)
                        val offset = offsetAnim.value + if (dragDistance > 0) -itemSize
                        else itemSize
                        offsetAnim.animateTo(
                            targetValue = offset,
                            animationSpec = tween(durationMillis = 100)
                        )
                    }
                }
            itemContent(itemModifier, index, item)
        }
    }
}