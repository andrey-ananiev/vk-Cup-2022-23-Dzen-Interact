package ru.keytomyself.dzeninteract.screens.pager.data

import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel

const val PAGES_QUIZ1_COUNT = 7
val listOfPagesQuiz1 = listOf(
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz1_title,
        subtitle = "1/$PAGES_QUIZ1_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_1_1,
        sourceLetterList = listOf('Д',  'Л', 'П', 'С', 'Р', 'К', 'Е', 'О', 'Т',  'А', 'Г', 'Б'),
        keyWord = "БЕРЕГ",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz1_title,
        subtitle = "2/$PAGES_QUIZ1_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_1_2,
        sourceLetterList = listOf('Д',  'Л', 'П', 'С', 'Р', 'К', 'Е', 'О', 'Т',  'А', 'В', 'Б'),
        keyWord = "ОСТРОВ",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz1_title,
        subtitle = "3/$PAGES_QUIZ1_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_1_3,
        sourceLetterList = listOf('Д',  'Л', 'П', 'С', 'Р', 'К', 'Т',  'А'),
        keyWord = "ПАРК",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz1_title,
        subtitle = "4/$PAGES_QUIZ1_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_1_4,
        sourceLetterList = listOf('Д',  'Г', 'П', 'С', 'Р', 'Й', 'Е', 'О', 'Т',  'А', 'И', 'Б'),
        keyWord = "АЙСБЕРГ",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz1_title,
        subtitle = "5/$PAGES_QUIZ1_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_1_5,
        sourceLetterList = listOf('Д',  'Л', 'П', 'С', 'Ф', 'К', 'Ь', 'О', 'Т',  'А', 'Ж', 'Б'),
        keyWord = "ДОЖДЬ",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz1_title,
        subtitle = "6/$PAGES_QUIZ1_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_1_6,
        sourceLetterList = listOf('Д',  'Л', 'П', 'С', 'Ь', 'К', 'Е'),
        keyWord = "ЕЛЬ",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz1_title,
        subtitle = "7/$PAGES_QUIZ1_COUNT",
        infoId = R.string.page_quiz_info2,
        imageId = R.drawable.question,
        sourceLetterList = listOf('Д',  'Л', 'П', 'С', 'Ф', 'К', 'Е', 'О', 'Т',  'А', 'Ж', 'Б'),
        keyWord = "ПОБЕДА",
        keyImageId = R.drawable.quiz_1_key
    ),
)