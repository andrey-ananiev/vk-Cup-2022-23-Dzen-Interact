package ru.keytomyself.dzeninteract.screens.pager.models

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.R

const val CLOUD_TAIL_SIZE = 30
const val CLOUD_PADDING = 20

sealed class CloudModel(
    open val tailId: Int = R.drawable.cloud_tail_1,
    open val tailSize: Int = CLOUD_TAIL_SIZE,
    open val tailAlign: Alignment = Alignment.TopEnd,
    open val tailRotate: Float = 0F,
    open val cloudPadding: PaddingValues = PaddingValues(top = CLOUD_PADDING.dp),
    open val textId: Int = R.string.page_empty_title,
    open val isDraggable: Boolean = true,
    open val isCorrect: Boolean = false,
    open val initXOffset: Float = 0F,
    open val initYOffset: Float = 0F,
) {
    var cloudXOffset by mutableStateOf(0F)
    var cloudYOffset by mutableStateOf(0F)

    data class TopEndLeft(
        override val tailId: Int = R.drawable.cloud_tail_1,
        override val tailSize: Int = CLOUD_TAIL_SIZE,
        override val tailAlign: Alignment = Alignment.TopEnd,
        override val tailRotate: Float = 0F,
        override val cloudPadding: PaddingValues = PaddingValues(top = CLOUD_PADDING.dp),
        override val textId: Int = R.string.page_empty_title,
        override val isDraggable: Boolean = true,
        override val isCorrect: Boolean = false,
        override val initXOffset: Float = 0F,
        override val initYOffset: Float = 0F,
    ) : CloudModel()

    data class TopEndRight(
        override val tailId: Int = R.drawable.cloud_tail_2,
        override val tailSize: Int = CLOUD_TAIL_SIZE,
        override val tailAlign: Alignment = Alignment.TopEnd,
        override val tailRotate: Float = 0F,
        override val cloudPadding: PaddingValues = PaddingValues(top = CLOUD_PADDING.dp),
        override val textId: Int = R.string.page_empty_title,
        override val isDraggable: Boolean = true,
        override val isCorrect: Boolean = false,
        override val initXOffset: Float = 0F,
        override val initYOffset: Float = 0F,
    ) : CloudModel()

    data class TopStartLeft(
        override val tailId: Int = R.drawable.cloud_tail_1,
        override val tailSize: Int = CLOUD_TAIL_SIZE,
        override val tailAlign: Alignment = Alignment.TopStart,
        override val tailRotate: Float = 0F,
        override val cloudPadding: PaddingValues = PaddingValues(top = CLOUD_PADDING.dp),
        override val textId: Int = R.string.page_empty_title,
        override val isDraggable: Boolean = true,
        override val isCorrect: Boolean = false,
        override val initXOffset: Float = 0F,
        override val initYOffset: Float = 0F,
    ) : CloudModel()

    data class TopStartRight(
        override val tailId: Int = R.drawable.cloud_tail_2,
        override val tailSize: Int = CLOUD_TAIL_SIZE,
        override val tailAlign: Alignment = Alignment.TopStart,
        override val tailRotate: Float = 0F,
        override val cloudPadding: PaddingValues = PaddingValues(top = CLOUD_PADDING.dp),
        override val textId: Int = R.string.page_empty_title,
        override val isDraggable: Boolean = true,
        override val isCorrect: Boolean = false,
        override val initXOffset: Float = 0F,
        override val initYOffset: Float = 0F,
    ) : CloudModel()

    data class BottomEndLeft(
        override val tailId: Int = R.drawable.cloud_tail_2,
        override val tailSize: Int = CLOUD_TAIL_SIZE,
        override val tailAlign: Alignment = Alignment.BottomEnd,
        override val tailRotate: Float = 180F,
        override val cloudPadding: PaddingValues = PaddingValues(bottom = CLOUD_PADDING.dp),
        override val textId: Int = R.string.page_empty_title,
        override val isDraggable: Boolean = true,
        override val isCorrect: Boolean = false,
        override val initXOffset: Float = 0F,
        override val initYOffset: Float = 0F,
    ) : CloudModel()

    data class BottomEndRight(
        override val tailId: Int = R.drawable.cloud_tail_1,
        override val tailSize: Int = CLOUD_TAIL_SIZE,
        override val tailAlign: Alignment = Alignment.BottomEnd,
        override val tailRotate: Float = 180F,
        override val cloudPadding: PaddingValues = PaddingValues(bottom = CLOUD_PADDING.dp),
        override val textId: Int = R.string.page_empty_title,
        override val isDraggable: Boolean = true,
        override val isCorrect: Boolean = false,
        override val initXOffset: Float = 0F,
        override val initYOffset: Float = 0F,
    ) : CloudModel()

    data class BottomStartLeft(
        override val tailId: Int = R.drawable.cloud_tail_2,
        override val tailSize: Int = CLOUD_TAIL_SIZE,
        override val tailAlign: Alignment = Alignment.BottomStart,
        override val tailRotate: Float = 180F,
        override val cloudPadding: PaddingValues = PaddingValues(bottom = CLOUD_PADDING.dp),
        override val textId: Int = R.string.page_empty_title,
        override val isDraggable: Boolean = true,
        override val isCorrect: Boolean = false,
        override val initXOffset: Float = 0F,
        override val initYOffset: Float = 0F,
    ) : CloudModel()

    data class BottomStartRight(
        override val tailId: Int = R.drawable.cloud_tail_1,
        override val tailSize: Int = CLOUD_TAIL_SIZE,
        override val tailAlign: Alignment = Alignment.BottomStart,
        override val tailRotate: Float = 180F,
        override val cloudPadding: PaddingValues = PaddingValues(bottom = CLOUD_PADDING.dp),
        override val textId: Int = R.string.page_empty_title,
        override val isDraggable: Boolean = true,
        override val isCorrect: Boolean = false,
        override val initXOffset: Float = 0F,
        override val initYOffset: Float = 0F,
    ) : CloudModel()
}


