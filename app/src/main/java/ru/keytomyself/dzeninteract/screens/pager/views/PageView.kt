package ru.keytomyself.dzeninteract.screens.pager.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel
import ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop.Draggable
import ru.keytomyself.dzeninteract.screens.pager.views.pages.*

@Composable
fun PageView(
    page: PageModel,
    onBackClicked: () -> Unit,
    onPositionChanged: (Int) -> Unit,
    onTextChanged: (Int, String) -> Unit,
    onItemDropped: (Int, Int) -> Unit,
    onLetterDropped: (Int, Char) -> Unit,
    onLetterReplaced: (Int, Boolean) -> Unit,
    onConfirmClick: () -> Unit,
    onRestart: () -> Unit,
    onCloudDropped: () -> Unit
) {
    Draggable(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            PageTitle(
                titleId = page.titleId,
                subTitle = page.subtitle,
                onBackClicked = onBackClicked
            )
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(top = 0.dp, bottom = 80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (page. infoId != null) {
                    PageInfo(page.infoId!!)
                }
                when (page) {
                    is PageModel.EditText -> EditTextView(page, onTextChanged)
                    is PageModel.SelectionLevel -> SelectionLevelView(page, onPositionChanged)
                    is PageModel.SelectionVariant -> SelectionVariantView(page, onPositionChanged)
                    is PageModel.SelectionMultiVariant -> SelectionMultiVariantView(page, onPositionChanged)
                    is PageModel.SelectionVariantCorrect -> SelectionVariantCorrectView(page, onPositionChanged)
                    is PageModel.DragText -> DragTextView(page, onItemDropped)
                    is PageModel.DragImage -> DragImageView(page, onItemDropped)
                    is PageModel.StarRating -> StarRatingView(page, onPositionChanged)
                    is PageModel.MappingText -> MappingTextView(page)
                    is PageModel.ImageTextPage -> ImageTextView(page)
                    is PageModel.ImageQuiz -> ImageQuizView(page, onLetterDropped, onLetterReplaced, onConfirmClick, onRestart)
                    is PageModel.ImageCloud -> ImageCloudView(page, onCloudDropped, onConfirmClick)
                }
            }
        }
    }
}