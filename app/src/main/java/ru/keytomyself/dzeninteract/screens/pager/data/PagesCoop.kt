package ru.keytomyself.dzeninteract.screens.pager.data

import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.CloudModel
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel

const val PAGES_COOP_COUNT = 6
val listOfPagesCoop = listOf(

    PageModel.ImageCloud(
        titleId = R.string.page_coop_title,
        subtitle = "1/$PAGES_COOP_COUNT",
        infoId = R.string.page_coop_info,
        imageId = R.drawable.coop_1,
        cloudList = listOf(
            CloudModel.TopEndLeft(
                textId = R.string.page_coop_1_1,
                isDraggable = false,
                initXOffset = 5F,
                initYOffset = 190F,
            ),
            CloudModel.TopStartRight(
                textId = R.string.page_coop_1_2a,
                isCorrect = true
            ),
            CloudModel.TopStartRight(
                textId = R.string.page_coop_1_2b,
                isCorrect = false
            ),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_coop_title,
        subtitle = "2/$PAGES_COOP_COUNT",
        infoId = null,
        imageId = R.drawable.coop_2,
        cloudList = listOf(
            CloudModel.TopStartLeft(
                textId = R.string.page_coop_2_1,
                isDraggable = false,
                initXOffset = 5F,
                initYOffset = 200F,
            ),
            CloudModel.TopEndRight(
                textId = R.string.page_coop_2_3,
                isDraggable = false,
                initXOffset = 200F,
                initYOffset = 200F,
            ),
            CloudModel.TopEndLeft(
                textId = R.string.page_coop_2_2a,
                isCorrect = false
            ),
            CloudModel.TopEndLeft(
                textId = R.string.page_coop_2_2b,
                isCorrect = true
            ),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_coop_title,
        subtitle = "3/$PAGES_COOP_COUNT",
        infoId = null,
        imageId = R.drawable.coop_3,
        cloudList = listOf(
            CloudModel.TopStartRight(
                textId = R.string.page_coop_3_1,
                isDraggable = false,
                initXOffset = 200F,
                initYOffset = 200F,
            ),
            CloudModel.TopEndLeft(
                textId = R.string.page_coop_3_2a,
                isCorrect = true
            ),
            CloudModel.TopEndLeft(
                textId = R.string.page_coop_3_2b,
                isCorrect = false
            ),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_coop_title,
        subtitle = "4/$PAGES_COOP_COUNT",
        infoId = null,
        imageId = R.drawable.coop_4,
        cloudList = listOf(
            CloudModel.TopStartRight(
                textId = R.string.page_coop_4_1,
                isDraggable = false,
                initXOffset = 200F,
                initYOffset = 150F,
            ),
            CloudModel.TopEndRight(
                textId = R.string.page_coop_4_2a,
                isCorrect = false
            ),
            CloudModel.TopEndRight(
                textId = R.string.page_coop_4_2b,
                isCorrect = true
            ),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_coop_title,
        subtitle = "5/$PAGES_COOP_COUNT",
        infoId = null,
        imageId = R.drawable.coop_5,
        cloudList = listOf(
            CloudModel.TopEndLeft(
                textId = R.string.page_coop_5_1,
                isDraggable = false,
                initXOffset = 20F,
                initYOffset = 200F,
            ),
            CloudModel.BottomStartRight(
                textId = R.string.page_coop_5_2a,
                isCorrect = false
            ),
            CloudModel.BottomStartRight(
                textId = R.string.page_coop_5_2b,
                isCorrect = true
            ),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_coop_title,
        subtitle = "6/$PAGES_COOP_COUNT",
        infoId = null,
        imageId = R.drawable.coop_6,
        isLastPage = true,
        cloudList = listOf(
            CloudModel.TopEndLeft(
                textId = R.string.page_coop_6_1,
                isDraggable = false,
                initXOffset = 5F,
                initYOffset = 220F,
            ),
            CloudModel.TopStartRight(
                textId = R.string.page_coop_6_2a,
                isCorrect = false
            ),
            CloudModel.TopStartRight(
                textId = R.string.page_coop_6_2b,
                isCorrect = true
            ),
        )
    ),
)