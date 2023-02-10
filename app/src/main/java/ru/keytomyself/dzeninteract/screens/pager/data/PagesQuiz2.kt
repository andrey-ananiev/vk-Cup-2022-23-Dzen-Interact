package ru.keytomyself.dzeninteract.screens.pager.data

import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel

const val PAGES_QUIZ2_COUNT = 5
val listOfPagesQuiz2 = listOf(
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz2_title,
        subtitle = "1/$PAGES_QUIZ2_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_2_1,
        sourceLetterList = listOf('Д',  'Л', 'В', 'С', 'Е', 'О', 'Т',  'А'),
        keyWord = "ЛЕС",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz2_title,
        subtitle = "2/$PAGES_QUIZ2_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_2_2,
        sourceLetterList = listOf('О',  'Л', 'З', 'Р', 'Е', 'О', 'Т',  'К'),
        keyWord = "ОЗЕРО",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz2_title,
        subtitle = "3/$PAGES_QUIZ2_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_2_3,
        sourceLetterList = listOf('Д',  'Я', 'В', 'С', 'Е', 'О', 'Г',  'А', 'Ы'),
        keyWord = "ЯГОДЫ",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz2_title,
        subtitle = "4/$PAGES_QUIZ2_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_2_4,
        sourceLetterList = listOf('Д',  'Л', 'В', 'С', 'Е', 'О', 'Т',  'А'),
        keyWord = "ВОДА",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz2_title,
        subtitle = "5/$PAGES_QUIZ2_COUNT",
        infoId = R.string.page_quiz_info2,
        imageId = R.drawable.question,
        sourceLetterList = listOf('Д',  'Л', 'В', 'С', 'Е', 'О', 'Т',  'Я'),
        keyWord = "ВОЛЯ",
        keyImageId = R.drawable.quiz_2_key
    ),
)