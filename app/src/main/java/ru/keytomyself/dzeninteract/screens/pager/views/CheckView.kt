package ru.keytomyself.dzeninteract.screens.pager.views

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.R

@Composable
fun VariantItem(
    isChecked: Boolean,
    textId: Int,
    iconId: Int
) {
    val size by animateDpAsState(
        targetValue = if (isChecked) 30.dp else 20.dp
    )
    val color by animateColorAsState(
        targetValue = if (isChecked) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.secondaryContainer
    )
    Box(modifier = Modifier
        .size(60.dp)
        .clip(RoundedCornerShape(30.dp))
        .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(size),
            painter = painterResource(id = iconId),
            contentDescription = stringResource(id = textId),
            tint = color
        )
    }
    Text(
        text = stringResource(id = textId),
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = if (isChecked) FontWeight.SemiBold
        else FontWeight.Normal
    )
}