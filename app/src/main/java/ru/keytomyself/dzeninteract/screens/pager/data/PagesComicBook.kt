package ru.keytomyself.dzeninteract.screens.pager.data

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.CloudModel
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel

const val PAGES_COMIC_COUNT = 8
val listOfPagesComicBook = listOf(

    PageModel.ImageCloud(
        titleId = R.string.page_comic5_title,
        subtitle = "1/$PAGES_COMIC_COUNT",
        infoId = R.string.page_comic_info,
        imageId = R.drawable.wait,
        cloudList = listOf(
            CloudModel.TopStartLeft(textId = R.string.page_comic_5_1),
            CloudModel.TopStartLeft(textId = R.string.page_comic_5_2),
            CloudModel.TopStartLeft(textId = R.string.page_comic_5_3),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_comic7_title,
        subtitle = "2/$PAGES_COMIC_COUNT",
        infoId = null,
        imageId = R.drawable.cat,
        cloudList = listOf(
            CloudModel.TopStartRight(textId = R.string.page_comic_7_1),
            CloudModel.TopEndLeft(textId = R.string.page_comic_7_2),
            CloudModel.TopEndLeft(textId = R.string.page_comic_7_3),
            CloudModel.TopStartRight(textId = R.string.page_comic_7_4),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_comic2_title,
        subtitle = "3/$PAGES_COMIC_COUNT",
        infoId = null,
        imageId = R.drawable.monkey,
        cloudList = listOf(
            CloudModel.BottomEndRight(textId = R.string.page_comic_2_1),
            CloudModel.TopEndRight(textId = R.string.page_comic_2_2),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_comic6_title,
        subtitle = "4/$PAGES_COMIC_COUNT",
        infoId = null,
        imageId = R.drawable.twice_in_bad,
        cloudList = listOf(
            CloudModel.TopEndLeft(
                textId = R.string.page_comic_6_1,
                isDraggable = false,
                initXOffset = 5F,
                initYOffset = 250F
            ),
            CloudModel.TopEndRight(textId = R.string.page_comic_6_2),
            CloudModel.TopEndRight(textId = R.string.page_comic_6_3),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_comic1_title,
        subtitle = "5/$PAGES_COMIC_COUNT",
        infoId = null,
        imageId = R.drawable.natasha,
        cloudList = listOf(
            CloudModel.TopEndLeft(
                textId = R.string.page_comic_1_2,
                isDraggable = false,
                initXOffset = 5F,
                initYOffset = 45F
            ),
            CloudModel.TopStartRight(
                textId = R.string.page_comic_1_1,
                isDraggable = false,
                initXOffset = 200F,
                initYOffset = 50F
            ),
            CloudModel.TopEndLeft(textId = R.string.page_comic_1_3),
            CloudModel.TopStartRight(textId = R.string.page_comic_1_4),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_comic3_title,
        subtitle = "6/$PAGES_COMIC_COUNT",
        infoId = null,
        imageId = R.drawable.man_and_two_girl,
        cloudList = listOf(
            CloudModel.TopEndRight(
                textId = R.string.page_comic_3_1,
                isDraggable = false,
                initXOffset = 260F,
                initYOffset = 200F
            ),
            CloudModel.TopEndRight(textId = R.string.page_comic_3_2),
            CloudModel.TopEndRight(textId = R.string.page_comic_3_3),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_comic4_title,
        subtitle = "7/$PAGES_COMIC_COUNT",
        infoId = null,
        imageId = R.drawable.crying_cat,
        cloudList = listOf(
            CloudModel.TopEndRight(textId = R.string.page_comic_4_1),
            CloudModel.TopStartLeft(textId = R.string.page_comic_4_2),
        )
    ),
    PageModel.ImageCloud(
        titleId = R.string.page_comic8_title,
        subtitle = "8/$PAGES_COMIC_COUNT",
        infoId = null,
        imageId = R.drawable.dicaprio,
        cloudList = listOf(
            CloudModel.TopEndRight(textId = R.string.page_comic_8_1),
            CloudModel.TopStartLeft(textId = R.string.page_comic_8_2),
            CloudModel.BottomStartLeft(textId = R.string.page_comic_8_3),
            CloudModel.BottomEndRight(textId = R.string.page_comic_8_4),
        )
    ),
)