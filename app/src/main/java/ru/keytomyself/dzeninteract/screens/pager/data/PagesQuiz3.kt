package ru.keytomyself.dzeninteract.screens.pager.data

import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel

const val PAGES_QUIZ3_COUNT = 6
val listOfPagesQuiz3 = listOf(

    PageModel.ImageQuiz(
        titleId = R.string.page_quiz3_title,
        subtitle = "1/$PAGES_QUIZ3_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_3_1,
        sourceLetterList = listOf('Д',  'Н', 'П', 'С', 'М', 'К', 'У', 'О', 'Т',  'А', 'Г', 'Б'),
        keyWord = "НУТ",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz3_title,
        subtitle = "2/$PAGES_QUIZ3_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_3_2,
        sourceLetterList = listOf('Д',  'Н', 'П', 'С', 'М', 'Л', 'Е', 'О', 'Т',  'А', 'Г', 'И'),
        keyWord = "МАЛИНА",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz3_title,
        subtitle = "3/$PAGES_QUIZ3_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_3_3,
        sourceLetterList = listOf('Ш',  'Н', 'У', 'С', 'М', 'Р', 'Е', 'О', 'Т',  'А', 'Г', 'Б'),
        keyWord = "ГРУША",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz3_title,
        subtitle = "4/$PAGES_QUIZ3_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_3_4,
        sourceLetterList = listOf('Д',  'Л', 'П', 'С', 'И', 'К', 'Е', 'О', 'Т',  'А', 'Г', 'В'),
        keyWord = "ОЛИВКА",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz3_title,
        subtitle = "5/$PAGES_QUIZ3_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_3_5,
        sourceLetterList = listOf('Д',  'Н', 'П', 'С', 'М', 'К', 'Е', 'О', 'Т',  'А', 'Г', 'Б'),
        keyWord = "АНАНАС",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz3_title,
        subtitle = "6/$PAGES_QUIZ3_COUNT",
        infoId = R.string.page_quiz_info2,
        imageId = R.drawable.question,
        sourceLetterList = listOf('Д', 'Н', 'П', 'С', 'М', 'К', 'Е', 'О', 'Т',  'А', 'Г', 'Б'),
        keyWord = "МАНГО",
        keyImageId = R.drawable.quiz_3_key
    ),
)