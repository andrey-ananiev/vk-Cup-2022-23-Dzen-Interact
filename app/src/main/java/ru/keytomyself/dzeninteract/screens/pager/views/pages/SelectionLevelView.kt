package ru.keytomyself.dzeninteract.screens.pager.views.pages

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel

@Composable
fun SelectionLevelView(
    page: PageModel.SelectionLevel,
    onPositionChanged: (Int) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 0.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .align(Alignment.BottomStart)
                .padding(end = 16.dp),
            text = stringResource(id = page.leftTextId),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .align(Alignment.BottomEnd)
                .padding(start = 16.dp),
            text = stringResource(id = page.rightTextId),
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodyMedium
        )
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 8.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9F)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top
        ) {
            for (pos in 1..7) {
                val size by animateDpAsState(
                    targetValue = if (pos == page.levelPosition) 45.dp else 25.dp
                )
                val color by animateColorAsState(
                    targetValue = if (pos == page.levelPosition) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.secondaryContainer
                )
                val x : Float = (pos - 4).toFloat()
                val yOffset = (- 2 * x * x + 10).toInt()
                Box(modifier = Modifier
                    .size(width = 45.dp, height = 70.dp)
                    .offset(y = yOffset.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier
                            .size(size)
                            .selectable(
                                selected = page.levelPosition == pos,
                                onClick = { onPositionChanged(pos) }
                            ),
                        shape = MaterialTheme.shapes.extraLarge,
                        colors = CardDefaults.cardColors(
                            containerColor = color
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 4.dp
                        )
                    ) { }
                }
            }
        }
        Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "Arrow up")
    }
}