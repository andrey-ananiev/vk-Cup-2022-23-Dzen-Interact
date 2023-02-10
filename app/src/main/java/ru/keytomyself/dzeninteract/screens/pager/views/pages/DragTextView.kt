package ru.keytomyself.dzeninteract.screens.pager.views.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel
import ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop.DraggableTextItem
import ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop.DropTarget
import ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop.TargetTextItem

@Composable
fun DragTextView(
    page: PageModel.DragText,
    onTextDropped: (Int, Int) -> Unit,
) {
    val wordList = stringResource(id = page.textId).replace(' ', '\n').lines()
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 16.dp),
        crossAxisAlignment = FlowCrossAxisAlignment.Center,
        mainAxisAlignment = FlowMainAxisAlignment.Center
    ) {

        var index = 0
        wordList.forEach { word ->
            if (word == "*") {
                val i = index
                DropTarget<Int>(
                    modifier = Modifier
                ) { isInBound, isDropped, data ->
                    if (isDropped) onTextDropped(i, data!!)
                    TargetTextItem(
                        text = stringResource(id = page.chosenVariantIdList[i]),
                        isInBound = isInBound,
                        isOnGap = true
                    )
                }
                index++
            } else {
                TargetTextItem(text = word)
            }
        }
    }
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 16.dp),
        mainAxisAlignment = FlowMainAxisAlignment.Center
    ) {
        page.variantIdList.forEach { item ->
            DraggableTextItem(
                text = item,
            )
        }
    }
}