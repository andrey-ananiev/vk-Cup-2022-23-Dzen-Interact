package ru.keytomyself.dzeninteract.screens.pager.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import ru.keytomyself.dzeninteract.R

sealed class PageModel(
    open val titleId: Int = R.string.page_empty_title,
    open val subtitle: String = "",
    open val infoId: Int? = null,
) {
    data class ImageCloud (
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int?,
        val imageId: Int,
        val cloudList: List<CloudModel> = emptyList(),
        val isLastPage: Boolean  = false
    ) : PageModel() {
        var isConfirmButtonVisible by mutableStateOf(false)
    }

    data class ImageQuiz (
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int?,
        val imageId: Int,
        val sourceLetterList: List<Char>,
        val keyWord: String,
        val keyImageId: Int? = null
    ) : PageModel() {
        var isConfirmButtonVisible by mutableStateOf(false)
        var isCorrect by mutableStateOf<Boolean?>(null)

        val targetLetterList = mutableStateListOf(' ')
        val indexLetterList = mutableStateListOf(0)
        init {
            targetLetterList.addAll(List(keyWord.length - 1) { ' ' })
            indexLetterList.addAll(List(keyWord.length - 1) { it + 1 })
        }
    }

    data class EditText (
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int?,
        val initialTopic: String = "",
        val initialNote: String = ""
    ) : PageModel() {
        var topic by mutableStateOf(initialTopic)
        var note by mutableStateOf(initialNote)

        companion object {
            const val TOPIC = 0
            const val NOTE = 1
        }
    }

    class SelectionLevel(
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int?,
        val leftTextId: Int,
        val rightTextId: Int,
        initialPosition: Int = 0
    ) : PageModel() {

        var levelPosition by mutableStateOf(initialPosition)
    }

    class SelectionVariant(
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int?,
        val variantIdList: List<Int>,
        initialPosition: Int = 0
    ) : PageModel() {

        var variantPosition by mutableStateOf(initialPosition)
    }

    class SelectionMultiVariant(
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int?,
        val variantIdList: List<Int>
    ) : PageModel() {

        val variantPositionList = mutableStateListOf(false)
        init {
            variantPositionList.addAll(List(variantIdList.size) { false })
        }
    }

    class SelectionVariantCorrect(
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int?,
        val variantIdList: List<Int>,
        val percentAnswered: List<Int>,
        val correctAnswer: Int,
        initialPosition: Int = 0
    ) : PageModel() {

        var variantPosition by mutableStateOf(initialPosition)
    }

    class DragText(
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int?,
        val textId: Int,
        val gapCount: Int,
        val variantIdList: List<Int>
    ) : PageModel() {
        val chosenVariantIdList = mutableStateListOf<Int>()
        init {
            chosenVariantIdList.addAll(List(gapCount) { R.string.page_dragText_gap })
        }
    }

    class DragImage(
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int?,
        val imageIdList: List<Int>,
    ) : PageModel() {
        val chosenImageIdList = mutableStateListOf<Int>()
        init {
            chosenImageIdList.addAll(List(4) { R.drawable.grag_image_gap })
        }
    }

    class StarRating(
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int? = null,
        initialStar: Int = 3
    ) : PageModel() {
        var star by mutableStateOf(initialStar)
    }

    class MappingText(
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int?,
        val leftTextIdList: List<Int>,
        rightTextIdListInitial: List<Int>
    ) : PageModel() {
        val rightTextIdList = mutableStateListOf<Int>()
        init {
            rightTextIdList.addAll(rightTextIdListInitial)
        }
    }

    class ImageTextPage(
        override val titleId: Int,
        override val subtitle: String,
        override val infoId: Int?,
        val imageId: Int,
        val textIdList: List<Int>,
        val textAlign: TextAlign
    ) : PageModel()
}