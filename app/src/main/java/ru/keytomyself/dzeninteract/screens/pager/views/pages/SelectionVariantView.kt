package ru.keytomyself.dzeninteract.screens.pager.views.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
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
fun SelectionVariantView(
    page: PageModel.SelectionVariant,
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
            verticalAlignment = Alignment.CenterVertically
        ) {
            VariantItem(
                isChecked = index == page.variantPosition,
                textId = variantId,
                iconId = R.drawable.ic_check
            )
        }
    }
}