package ru.keytomyself.dzeninteract.screens.pager.views.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel
import ru.keytomyself.dzeninteract.screens.pager.views.VariantItem

@Composable
fun SelectionVariantCorrectView(
    page: PageModel.SelectionVariantCorrect,
    onPositionChanged: (Int) -> Unit,
) {
    page.variantIdList.forEachIndexed { i, variantId ->
        val index = i + 1
        Row(
            modifier = Modifier
                .fillMaxWidth(0.7F)
                .clip(MaterialTheme.shapes.medium)
                .selectable(
                    selected = page.variantPosition == index,
                    onClick = { onPositionChanged(index) }
                )
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(0.7F),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val iconId = if (page.variantPosition > 0) if (index == page.correctAnswer)
                    R.drawable.ic_check else R.drawable.ic_cross
                    else R.drawable.ic_question
                VariantItem(
                    isChecked = index == page.variantPosition,
                    textId = variantId,
                    iconId = iconId
                )
            }
            if (page.variantPosition > 0)
                Text(
                    text = "${page.percentAnswered[i]}%",
                    style = MaterialTheme.typography.bodySmall
                )
        }
    }
}