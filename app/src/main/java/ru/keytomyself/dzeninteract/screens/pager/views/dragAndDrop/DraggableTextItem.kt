package ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun DraggableTextItem(
    modifier: Modifier = Modifier,
    text: Any,
) {
    val isTextChar = text is Char
    DragTarget(
        modifier = modifier.padding(6.dp),
        dataToDrop = text,
    ) {
        Card(
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                text = if (isTextChar) (text as Char).toString() else stringResource(id = text as Int),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}