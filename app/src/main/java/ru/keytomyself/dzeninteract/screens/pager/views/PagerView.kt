package ru.keytomyself.dzeninteract.screens.pager.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import ru.keytomyself.dzeninteract.screens.pager.models.PagerViewState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerView(
    state: PagerViewState.PagerMain,
    onBackClicked: () -> Unit,
    onPositionChanged: (Int, Int) -> Unit,
    onTextChanged: (Int, Int, String) -> Unit,
    onItemDropped: (Int, Int, Int) -> Unit,
    onLetterDropped: (Int, Int, Char) -> Unit,
    onLetterReplaced: (Int, Int, Boolean) -> Unit,
    onConfirmClick: (Int) -> Unit,
    onRestart: (Int) -> Unit,
    onCloudDropped: (Int) -> Unit
) {
    val pagerState = rememberPagerState()
    val density = LocalDensity.current
    val scope = rememberCoroutineScope()

    Surface(
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            HorizontalPager(
                count = state.pageList.size,
                state = pagerState
            ) { pagerPos ->

                PageView(
                    page = state.pageList[pagerPos],
                    onBackClicked = onBackClicked,
                    onPositionChanged = { onPositionChanged(pagerPos, it) },
                    onTextChanged = { index, text -> onTextChanged(pagerPos, index, text) },
                    onItemDropped = { index, textId -> onItemDropped(pagerPos, index, textId) },
                    onLetterDropped = { index, char -> onLetterDropped(pagerPos, index, char) },
                    onLetterReplaced = { index, isToRight -> onLetterReplaced(pagerPos, index, isToRight)},
                    onConfirmClick = { onConfirmClick(pagerPos) },
                    onRestart = { onRestart(pagerPos)},
                    onCloudDropped = { onCloudDropped(pagerPos) }
                )
            }
            Card(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 36.dp),
                shape = MaterialTheme.shapes.large,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface
                )
            ) {
                val d = pagerState.pageCount / 10 + 1
                HorizontalPagerIndicator(
                    modifier = Modifier.padding(8.dp),
                    pagerState = pagerState,
                    activeColor = MaterialTheme.colorScheme.primary,
                    inactiveColor = MaterialTheme.colorScheme.secondaryContainer,
                    indicatorWidth = 10.dp,
                    indicatorHeight = 10.dp,
                    pageIndexMapping = {
                        it / d
                    },
                    pageCount = pagerState.pageCount / d
                )
            }
            AnimatedVisibility(
                modifier = Modifier.align(Alignment.BottomStart),
                visible = pagerState.currentPage > 0,
                enter = slideInHorizontally{ with(density) { (-80).dp.roundToPx() } },
                exit = slideOutHorizontally{ with(density) { (-80).dp.roundToPx() } }
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(24.dp)
                        .size(50.dp, 50.dp),
                    colors = IconButtonDefaults.outlinedIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage > 0)
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowLeft,
                        contentDescription = "Backward"
                    )
                }
            }
            AnimatedVisibility(
                modifier = Modifier.align(Alignment.BottomEnd),
                visible = pagerState.currentPage < pagerState.pageCount - 1,
                enter = slideInHorizontally{ with(density) { 80.dp.roundToPx() } },
                exit = slideOutHorizontally{ with(density) { 80.dp.roundToPx() } }
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(24.dp)
                        .size(50.dp, 50.dp),
                    colors = IconButtonDefaults.outlinedIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
                        scope.launch {
                            if (pagerState.currentPage < pagerState.pageCount - 1)
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowRight,
                        contentDescription = "Forward"
                    )
                }
            }
//            PagerConfirmButton(
//                isConfirmButtonVisible = state.isConfirmButtonVisible,
//                modifier = Modifier
//                    .align(Alignment.BottomCenter)
//                    .padding(bottom = 24.dp),
//                onConfirmClick = { onConfirmClick(pagerState.currentPage) }
//            )
        }
    }
}