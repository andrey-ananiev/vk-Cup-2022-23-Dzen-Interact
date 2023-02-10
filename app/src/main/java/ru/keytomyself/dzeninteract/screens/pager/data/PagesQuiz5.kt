package ru.keytomyself.dzeninteract.screens.pager.data

import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel

const val PAGES_QUIZ5_COUNT = 5
val listOfPagesQuiz5 = listOf(

    PageModel.ImageQuiz(
        titleId = R.string.page_quiz5_title,
        subtitle = "1/$PAGES_QUIZ5_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_5_1,
        sourceLetterList = listOf('Д', 'В', 'Л', 'Ц', 'Е', 'О', 'И', 'А'),
        keyWord = "ОВЦА",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz5_title,
        subtitle = "2/$PAGES_QUIZ5_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_5_2,
        sourceLetterList = listOf('Д', 'В', 'Л', 'Б', 'Е', 'О', 'Ю', 'Р'),
        keyWord = "ВЕРБЛЮД",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz5_title,
        subtitle = "3/$PAGES_QUIZ5_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_5_3,
        sourceLetterList = listOf('Д', 'В', 'Т', 'С', 'Е', 'О', 'И', 'К'),
        keyWord = "КОТ",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz5_title,
        subtitle = "4/$PAGES_QUIZ5_COUNT",
        infoId = R.string.page_quiz_info,
        imageId = R.drawable.quiz_5_4,
        sourceLetterList = listOf('Д', 'В', 'Л', 'С', 'Е', 'А', 'И', 'К'),
        keyWord = "ЛИСА",
    ),
    PageModel.ImageQuiz(
        titleId = R.string.page_quiz5_title,
        subtitle = "5/$PAGES_QUIZ5_COUNT",
        infoId = R.string.page_quiz_info2,
        imageId = R.drawable.question,
        sourceLetterList = listOf('Д', 'В', 'Л', 'С', 'Е', 'О', 'И', 'К'),
        keyWord = "ВОЛК",
        keyImageId = R.drawable.quiz_5_key
    ),
)