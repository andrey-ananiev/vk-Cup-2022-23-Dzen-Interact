package ru.keytomyself.dzeninteract.screens.pager.views.pages

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel
import ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop.DragForSwap

const val LINE_HEIGHT = 72

@Composable
fun MappingTextView(
    page: PageModel.MappingText,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {

        Column(
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .height((page.rightTextIdList.size * LINE_HEIGHT).dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            page.leftTextIdList.forEach { leftTextId ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 22.dp),
                    text = stringResource(id = leftTextId),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.End
                )
            }
        }

        DragForSwap(
            itemList = page.rightTextIdList,
            orientation = Orientation.Vertical,
            itemSize = LINE_HEIGHT,
            onLetterReplaced = { _, _ ->}
        ) { modifier, _, textId ->
            Card(
                modifier = modifier,
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 16.dp),
                    text = stringResource(id = textId),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}