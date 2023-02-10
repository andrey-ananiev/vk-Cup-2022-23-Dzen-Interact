package ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TargetTextItem(
    modifier: Modifier = Modifier,
    text: String,
    isInBound: Boolean = false,
    isOnGap: Boolean = false
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        border = if (isInBound) BorderStroke(2.dp, MaterialTheme.colorScheme.primary) else null
    ) {
        Text(
            modifier = Modifier.padding(if (isOnGap) 6.dp else 2.dp),
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = if (isOnGap) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurface
        )
    }
}