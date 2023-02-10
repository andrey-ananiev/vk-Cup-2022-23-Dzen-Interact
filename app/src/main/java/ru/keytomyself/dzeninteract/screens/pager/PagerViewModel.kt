package ru.keytomyself.dzeninteract.screens.pager

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.keytomyself.dzeninteract.screens.pager.data.*
import ru.keytomyself.dzeninteract.screens.pager.models.IntentHandler
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel.EditText.Companion.NOTE
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel.EditText.Companion.TOPIC
import ru.keytomyself.dzeninteract.screens.pager.models.PagerIntent
import ru.keytomyself.dzeninteract.screens.pager.models.PagerViewState
import ru.keytomyself.dzeninteract.screens.pager.views.START_COMIC
import ru.keytomyself.dzeninteract.screens.pager.views.START_COOP
import ru.keytomyself.dzeninteract.screens.pager.views.START_INTERACT
import ru.keytomyself.dzeninteract.screens.pager.views.*

class PagerViewModel : ViewModel(), IntentHandler<PagerIntent> {

    private val _pagerViewState: MutableLiveData<PagerViewState> =
        MutableLiveData(PagerViewState.PagerInitial)
    val pagerViewState: LiveData<PagerViewState> = _pagerViewState

    override fun obtainIntent(intent: PagerIntent) {
        when (val currentViewState = _pagerViewState.value) {
            is PagerViewState.PagerInitial -> reduce(intent)
            is PagerViewState.PagerStart -> reduce(intent, currentViewState)
            is PagerViewState.PagerMain -> reduce(intent, currentViewState)
            is PagerViewState.PagerResult -> if(intent is PagerIntent.BackClicked) _pagerViewState.postValue(PagerViewState.PagerStart)
            else -> {}
        }
    }

    private fun reduce(intent: PagerIntent) {
        when (intent) {
            PagerIntent.EnterScreen -> _pagerViewState.postValue(PagerViewState.PagerStart)
//                _pagerViewState.postValue(PagerViewState.PagerMain(
//                    pageList = listOfPagesQuiz2
//                ))
            else -> {}
        }
    }

    private fun reduce(intent: PagerIntent, state: PagerViewState.PagerStart) {
        when (intent) {
            is PagerIntent.StartPager -> {
                when (intent.pagerIndex) {
                    START_QUIZ1 -> _pagerViewState.postValue(PagerViewState.PagerMain(
                        pageList = listOfPagesQuiz1
                    ))
                    START_QUIZ2 -> _pagerViewState.postValue(PagerViewState.PagerMain(
                        pageList = listOfPagesQuiz2
                    ))
                    START_QUIZ3 -> _pagerViewState.postValue(PagerViewState.PagerMain(
                        pageList = listOfPagesQuiz3
                    ))
                    START_QUIZ4 -> _pagerViewState.postValue(PagerViewState.PagerMain(
                        pageList = listOfPagesQuiz4
                    ))
                    START_QUIZ5 -> _pagerViewState.postValue(PagerViewState.PagerMain(
                        pageList = listOfPagesQuiz5
                    ))
                    START_COMIC -> _pagerViewState.postValue(PagerViewState.PagerMain(
                        pageList = listOfPagesComicBook
                    ))
                    START_COOP -> _pagerViewState.postValue(PagerViewState.PagerMain(
                        pageList = listOfPagesCoop
                    ))
                    START_INTERACT -> _pagerViewState.postValue(PagerViewState.PagerMain(
                        pageList = listOfPagesInteract
                    ))
                }
            }
            else -> {}
        }
    }

    private fun reduce(intent: PagerIntent, state: PagerViewState.PagerMain) {
        when (intent) {
            is PagerIntent.BackClicked -> _pagerViewState.postValue(PagerViewState.PagerStart)
            is PagerIntent.TextChanged -> textChanged(intent, state)
            is PagerIntent.PositionChanged -> positionChanged(intent, state)
            is PagerIntent.ItemDropped -> textDropped(intent, state)
            is PagerIntent.LetterDropped -> letterDropped(intent, state)
            is PagerIntent.LetterReplaced -> letterReplaced(intent, state)
            is PagerIntent.ConfirmClicked -> confirmClicked(intent, state)
            is PagerIntent.Restart -> restart(intent, state)
            is PagerIntent.CloudDropped -> cloudDropped(intent, state)
            else -> {}
        }
    }

    private fun textChanged(intent: PagerIntent.TextChanged, state: PagerViewState.PagerMain) {

        val pageList = List(state.pageList.size) { state.pageList[it]}
        when(val page = pageList[intent.pageIndex]) {
            is PageModel.EditText -> {
                when(intent.textIndex) {
                    TOPIC -> page.topic = intent.text
                    NOTE -> page.note = intent.text
                }
            }
            else -> {}
        }
        _pagerViewState.postValue(state.copy(pageList = pageList))
    }

    private fun positionChanged(intent: PagerIntent.PositionChanged, state: PagerViewState.PagerMain) {

        val pageList = List(state.pageList.size) { state.pageList[it]}
        when(val page = pageList[intent.pageIndex]) {
            is PageModel.SelectionLevel -> page.levelPosition = intent.position
            is PageModel.SelectionVariant -> page.variantPosition = intent.position
            is PageModel.SelectionMultiVariant ->
                page.variantPositionList[intent.position] = !page.variantPositionList[intent.position]
            is PageModel.SelectionVariantCorrect -> if (page.variantPosition == 0) page.variantPosition = intent.position
            is PageModel.StarRating -> page.star = intent.position
            else -> {}
        }
        _pagerViewState.postValue(state.copy(pageList = pageList))
    }

    private fun textDropped(intent: PagerIntent.ItemDropped, state: PagerViewState.PagerMain) {

        val pageList = List(state.pageList.size) { state.pageList[it]}
        when (val page = pageList[intent.pageIndex]) {
            is PageModel.DragText -> page.chosenVariantIdList[intent.itemIndex] = intent.itemId
            is PageModel.DragImage -> page.chosenImageIdList[intent.itemIndex] = intent.itemId
            is PageModel.MappingText -> {
            }
            else -> {}
        }
        _pagerViewState.postValue(state.copy(pageList = pageList))
    }

    private fun letterDropped(intent: PagerIntent.LetterDropped, state: PagerViewState.PagerMain) {

        var isVisible = true
        val pageList = List(state.pageList.size) { state.pageList[it]}
        when (val page = pageList[intent.pageIndex]) {
            is PageModel.ImageQuiz -> {
                page.targetLetterList[intent.itemIndex] = intent.char
                page.targetLetterList.forEach { letter ->
                    if (letter == ' ') isVisible = false
                }
                page.isConfirmButtonVisible = isVisible
                page.isCorrect = null
            }
            else -> {}
        }
        _pagerViewState.postValue(state.copy(
            pageList = pageList
        ))
    }

    private fun letterReplaced(intent: PagerIntent.LetterReplaced, state: PagerViewState.PagerMain) {

        val pageList = List(state.pageList.size) { state.pageList[it]}
        when (val page = pageList[intent.pageIndex]) {
            is PageModel.ImageQuiz -> {
                val index = page.indexLetterList.indexOf(intent.itemIndex)
                val index2 = if (!intent.isToRight) index - 1 else index + 1
                val item = page.indexLetterList[index]
                page.indexLetterList[index] = page.indexLetterList[index2]
                page.indexLetterList[index2] = item
                page.isCorrect = null
            }
            else -> {}
        }
        _pagerViewState.postValue(state.copy(pageList = pageList))
    }

    private fun cloudDropped(intent: PagerIntent.CloudDropped, state: PagerViewState.PagerMain) {

        val pageList = List(state.pageList.size) { state.pageList[it]}
        when (val page = pageList[intent.pageIndex]) {
            is PageModel.ImageCloud -> {
                page.isConfirmButtonVisible = true
            }
            else -> {}
        }
        _pagerViewState.postValue(state.copy(pageList = pageList))
    }

    private fun confirmClicked(intent: PagerIntent.ConfirmClicked, state: PagerViewState.PagerMain) {

        val pageList = List(state.pageList.size) { state.pageList[it]}
        when (val page = pageList[intent.pageIndex]) {
            is PageModel.ImageQuiz -> {
                var result = true
                page.indexLetterList.forEachIndexed { index, letterIndex ->
                    if (page.keyWord[index] != page.targetLetterList[letterIndex]) result = false
                }
                page.isCorrect = result
                _pagerViewState.postValue(state.copy(pageList = pageList ))
            }

            is PageModel.ImageCloud -> {
                var result = 0
                pageList.forEach { page ->
                    if (page is PageModel.ImageCloud) {
                        var isPageCorrect = true
                        page.cloudList.forEach { cloud ->
                            if(cloud.isDraggable) {
                                val yPos = cloud.initYOffset + cloud.cloudYOffset
                                if (cloud.isCorrect && yPos >= 0) isPageCorrect = false
                                if (!cloud.isCorrect && yPos < 0) isPageCorrect = false
                            }
                        }
                        result += if (isPageCorrect) 1 else 0
                    }
                }
                _pagerViewState.postValue(PagerViewState.PagerResult(result = result))
            }
            else -> {}
        }
    }

    private fun restart(intent: PagerIntent.Restart, state: PagerViewState.PagerMain) {

        val pageList = List(state.pageList.size) { state.pageList[it]}
        when (val page = pageList[intent.pageIndex]) {
            is PageModel.ImageQuiz -> {
                val letterList = mutableListOf<Char>()
                page.indexLetterList.forEach { index ->
                    letterList.add(page.targetLetterList[index])
                }
                page.targetLetterList.clear()
                page.targetLetterList.addAll(letterList)
                page.indexLetterList.clear()
                page.indexLetterList.addAll(List(page.targetLetterList.size) { it })
            }
            else -> {}
        }
        _pagerViewState.postValue(state.copy(
            pageList = pageList
        ))
    }
}