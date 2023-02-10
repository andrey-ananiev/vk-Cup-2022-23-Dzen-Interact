package ru.keytomyself.dzeninteract.screens.pager.models

sealed class PagerViewState {
    object PagerInitial : PagerViewState()

    object PagerStart : PagerViewState()

    data class PagerMain(
        val pageList: List<PageModel> = emptyList()
    ): PagerViewState()

    data class PagerResult(val result: Int) : PagerViewState()
}