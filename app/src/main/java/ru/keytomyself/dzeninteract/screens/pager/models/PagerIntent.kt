package ru.keytomyself.dzeninteract.screens.pager.models

sealed class PagerIntent {
    object EnterScreen : PagerIntent()
    data class StartPager(val pagerIndex: Int) : PagerIntent()
    object BackClicked : PagerIntent()

    data class PositionChanged(val pageIndex: Int, val position: Int): PagerIntent()
    data class TextChanged(val pageIndex: Int, val textIndex: Int, val text: String): PagerIntent()
    data class ItemDropped(val pageIndex: Int, val itemIndex: Int, val itemId: Int): PagerIntent()
    data class LetterDropped(val pageIndex: Int, val itemIndex: Int, val char: Char): PagerIntent()
    data class LetterReplaced(val pageIndex: Int, val itemIndex: Int, val isToRight: Boolean): PagerIntent()
    data class ConfirmClicked(val pageIndex: Int) : PagerIntent()
    data class Restart(val pageIndex: Int) : PagerIntent()
    data class CloudDropped(val pageIndex: Int): PagerIntent()

}