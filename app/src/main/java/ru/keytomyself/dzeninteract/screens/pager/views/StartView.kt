package ru.keytomyself.dzeninteract.screens.pager.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.views.pages.IMAGE_HEIGHT

const val START_QUIZ1 = 0
const val START_QUIZ2 = 1
const val START_QUIZ3 = 2
const val START_QUIZ4 = 3
const val START_QUIZ5 = 4
const val START_COMIC = 5
const val START_COOP = 6
const val START_INTERACT = 7

@Composable
fun StartView (
    onStartButtonClick: (Int) -> Unit
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        val imageIdList = listOf(
            R.drawable.main_1,
            R.drawable.main_2,
            R.drawable.main_3,
            R.drawable.main_4,
            R.drawable.main_5,
            R.drawable.main_6,
            R.drawable.main_7,
            R.drawable.main_8,
        )
        val textIdList = listOf(
            R.string.page_quiz1_title,
            R.string.page_quiz2_title,
            R.string.page_quiz3_title,
            R.string.page_quiz4_title,
            R.string.page_quiz5_title,
            R.string.start_button_comic,
            R.string.start_button_coop,
            R.string.start_button_interact,
        )

        LazyVerticalGrid(
            modifier = Modifier.padding(4.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.Center
        ) {
            for (index in 0..7) {
                item {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp)
                        .clickable { onStartButtonClick(index) }
                    ) {
                        Image(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp)
                                .clip(MaterialTheme.shapes.medium),
                            painter = painterResource(id = imageIdList[index]),
                            contentDescription = "main image",
                            contentScale = ContentScale.FillWidth
                        )
                        Card(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .fillMaxWidth(0.8F)
                                .height(75.dp)
                                .alpha(0.85F),
                            shape = MaterialTheme.shapes.extraLarge
                        ) {

                        }
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = stringResource(id = textIdList[index]),
                            style = MaterialTheme.typography.headlineSmall,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.W400
                        )
                    }
                }
            }
        }
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Button(onClick = { onStartButtonClick(START_QUIZ1) }) {
//                Text(
//                    text = stringResource(id = R.string.page_quiz1_title),
//                    style = MaterialTheme.typography.titleSmall
//                )
//            }
//            Button(onClick = { onStartButtonClick(START_QUIZ2) }) {
//                Text(
//                    text = stringResource(id = R.string.page_quiz2_title),
//                    style = MaterialTheme.typography.titleSmall
//                )
//            }
//            Button(onClick = { onStartButtonClick(START_QUIZ3) }) {
//                Text(
//                    text = stringResource(id = R.string.page_quiz3_title),
//                    style = MaterialTheme.typography.titleSmall
//                )
//            }
//            Button(onClick = { onStartButtonClick(START_QUIZ4) }) {
//                Text(
//                    text = stringResource(id = R.string.page_quiz4_title),
//                    style = MaterialTheme.typography.titleSmall
//                )
//            }
//            Button(onClick = { onStartButtonClick(START_QUIZ5) }) {
//                Text(
//                    text = stringResource(id = R.string.page_quiz5_title),
//                    style = MaterialTheme.typography.titleSmall
//                )
//            }
//            Button(onClick = { onStartButtonClick(START_COMIC) }) {
//                Text(
//                    text = stringResource(id = R.string.start_button_comic),
//                    style = MaterialTheme.typography.titleSmall
//                )
//            }
//            Button(onClick = { onStartButtonClick(START_COOP) }) {
//                Text(
//                    text = stringResource(id = R.string.start_button_coop),
//                    style = MaterialTheme.typography.titleSmall
//                )
//            }
//            Button(onClick = { onStartButtonClick(START_INTERACT) }) {
//                Text(
//                    text = stringResource(id = R.string.start_button_interact),
//                    style = MaterialTheme.typography.titleSmall
//                )
//            }
//        }
    }
}