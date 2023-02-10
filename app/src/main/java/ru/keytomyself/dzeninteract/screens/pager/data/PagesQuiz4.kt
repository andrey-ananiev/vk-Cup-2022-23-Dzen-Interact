package ru.keytomyself.dzeninteract.screens.pager.data

import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel

const val PAGES_QUIZ4_COUNT = 5
val listOfPagesQuiz4 = listOf(

    PageModel.ImageQuiz(
        titleId = R.string.page_quiz4_title,
        subtitle = "1/$PAGES_QUIZ4_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_4_1,
        sourceLetterList = listOf('А', 'Н', 'Т', 'С', 'К', 'О', 'У', 'Г'),
        keyWord = "УТКА",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz4_title,
        subtitle = "2/$PAGES_QUIZ4_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_4_2,
        sourceLetterList = listOf('Ы', 'Н', 'Р', 'С', 'Е', 'О', 'У', 'Ь'),
        keyWord = "РЫСЬ",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz4_title,
        subtitle = "3/$PAGES_QUIZ4_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_4_3,
        sourceLetterList = listOf('Б', 'Ь', 'Л', 'С', 'Е', 'О', 'У', 'Г'),
        keyWord = "ГОЛУБЬ",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz4_title,
        subtitle = "4/$PAGES_QUIZ4_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_4_4,
        sourceLetterList = listOf('Д', 'Н', 'Р', 'С', 'Е', 'О', 'У', 'В'),
        keyWord = "ДЕРЕВО",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz4_title,
        subtitle = "5/$PAGES_QUIZ4_COUNT",
        infoId = R.string.page_quiz_info2,
        imageId = R.drawable.question,
        sourceLetterList = listOf('Д', 'Н', 'Р', 'С', 'Е', 'О', 'У', 'Г'),
        keyWord = "ДРУГ",
        keyImageId = R.drawable.quiz_4_key
    ),
)