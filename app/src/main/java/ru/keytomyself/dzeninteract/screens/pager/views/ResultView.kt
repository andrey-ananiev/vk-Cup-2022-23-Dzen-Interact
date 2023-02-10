package ru.keytomyself.dzeninteract.screens.pager.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PagerViewState

@Composable
fun ResultView(
    state: PagerViewState.PagerResult,
    onBackClicked: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        IconButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart),
            onClick = onBackClicked
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow back"
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.9F)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(shape = MaterialTheme.shapes.large),
                painter = painterResource(id = R.drawable.result),
                contentDescription = "result image",
                contentScale = ContentScale.FillWidth
            )
            val title = stringResource(id = R.string.page_coop_result) +
                    " " + state.result.toString() + "/6"
            Text(
                modifier = Modifier.padding(16.dp),
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            val description = when(state.result) {
                0,1,2 -> stringResource(id = R.string.page_coop_result_low)
                3,4,5 -> stringResource(id = R.string.page_coop_result_medium)
                6 -> stringResource(id = R.string.page_coop_result_high)
                else -> ""
            }
            Text(
                text = description,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}