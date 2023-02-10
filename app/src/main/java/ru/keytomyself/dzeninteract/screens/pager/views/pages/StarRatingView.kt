package ru.keytomyself.dzeninteract.screens.pager.views.pages

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel

@Composable
fun StarRatingView(
    page: PageModel.StarRating,
    onClickStar: (Int) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (position in 1..5) {
                val size by animateDpAsState(
                    targetValue = if (position <= page.star) 60.dp else 40.dp
                )
                val color by animateColorAsState(
                    targetValue = if (position <= page.star) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.secondaryContainer
                )
                Box(modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .size(size)
                            .selectable(
                                selected = page.star == position,
                                onClick = { onClickStar(position) }
                            ),
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "star",
                        tint = color
                    )
                }
            }
        }
    }
}