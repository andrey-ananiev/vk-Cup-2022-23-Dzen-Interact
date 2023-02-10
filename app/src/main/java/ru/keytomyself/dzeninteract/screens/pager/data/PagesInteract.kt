package ru.keytomyself.dzeninteract.screens.pager.data

import androidx.compose.ui.text.style.TextAlign
import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel

const val PAGES_INTERACT_COUNT = 11
val listOfPagesInteract = listOf(

    PageModel.ImageTextPage(
        titleId = R.string.page_welcome_title,
        subtitle = "1/$PAGES_INTERACT_COUNT",
        infoId = R.string.page_welcome_info,
        imageId = R.drawable.welcome,
        textIdList = listOf(R.string.page_welcome_text),
        textAlign = TextAlign.Center
    ),
    PageModel.SelectionVariant(
        titleId = R.string.page_variant_title,
        subtitle = "2/$PAGES_INTERACT_COUNT",
        infoId = R.string.page_variant_info,
        variantIdList = listOf(
            R.string.page_variant_1,
            R.string.page_variant_2,
            R.string.page_variant_3,
            R.string.page_variant_4,
            R.string.page_variant_5
        ),
    ),
    PageModel.SelectionMultiVariant(
        titleId = R.string.page_multiVariant_title,
        subtitle = "3/$PAGES_INTERACT_COUNT",
        infoId = R.string.page_multiVariant_info,
        variantIdList = listOf(
            R.string.page_multiVariant_1,
            R.string.page_multiVariant_2,
            R.string.page_multiVariant_3,
            R.string.page_multiVariant_4,
            R.string.page_multiVariant_5,
            R.string.page_multiVariant_6,
        )
    ),
    PageModel.SelectionVariantCorrect(
        titleId = R.string.page_variant_correct_title,
        subtitle = "4/$PAGES_INTERACT_COUNT",
        infoId = R.string.page_variant_correct_info,
        variantIdList = listOf(
            R.string.page_variant_correct_1,
            R.string.page_variant_correct_2,
            R.string.page_variant_correct_3,
            R.string.page_variant_correct_4,
            R.string.page_variant_correct_5
        ),
        percentAnswered = listOf(38, 34, 16, 10, 2),
        correctAnswer = 2
    ),
    PageModel.SelectionLevel(
        titleId = R.string.page_level_title,
        subtitle = "5/$PAGES_INTERACT_COUNT",
        infoId = R.string.page_level_info,
        leftTextId = R.string.page_level_left,
        rightTextId = R.string.page_level_right
    ),
    PageModel.MappingText(
        titleId = R.string.page_mappingText_title,
        subtitle = "6/$PAGES_INTERACT_COUNT",
        infoId = R.string.page_mappingText_info,
        leftTextIdList = listOf(
            R.string.page_mappingText_left_1,
            R.string.page_mappingText_left_2,
            R.string.page_mappingText_left_3,
            R.string.page_mappingText_left_4,
        ),
        rightTextIdListInitial = listOf(
            R.string.page_mappingText_right_1,
            R.string.page_mappingText_right_2,
            R.string.page_mappingText_right_3,
            R.string.page_mappingText_right_4,
        )
    ),
    PageModel.DragText(
        titleId = R.string.page_dragText_title,
        subtitle = "7/$PAGES_INTERACT_COUNT",
        infoId = R.string.page_dragText_info,
        textId = R.string.page_dragText_text,
        gapCount = 5,
        variantIdList = listOf(
            R.string.page_dragText_1,
            R.string.page_dragText_2,
            R.string.page_dragText_3,
            R.string.page_dragText_4,
            R.string.page_dragText_5
        )
    ),
    PageModel.DragImage(
        titleId = R.string.page_dragImage_title,
        subtitle = "8/$PAGES_INTERACT_COUNT",
        infoId = R.string.page_dragImage_info,
        imageIdList = listOf(
            R.drawable.grag_image_1,
            R.drawable.grag_image_2,
            R.drawable.grag_image_3,
            R.drawable.grag_image_4,
        )
    ),
    PageModel.EditText(
        titleId = R.string.page_note_title,
        subtitle = "9/$PAGES_INTERACT_COUNT",
        infoId = R.string.page_note_info,
    ),
    PageModel.StarRating(
        titleId = R.string.page_star_title,
        subtitle = "10/$PAGES_INTERACT_COUNT",
    ),
    PageModel.ImageTextPage(
        titleId = R.string.page_goodbye_title,
        subtitle = "11/$PAGES_INTERACT_COUNT",
        infoId = R.string.page_goodbye_info,
        imageId = R.drawable.all_cups,
        textIdList = listOf(
            R.string.page_goodbye_text_1,
            R.string.page_goodbye_text_2,
            R.string.page_goodbye_text_3,
            R.string.page_goodbye_text_4,
        ),
        textAlign = TextAlign.Start
    ),
)