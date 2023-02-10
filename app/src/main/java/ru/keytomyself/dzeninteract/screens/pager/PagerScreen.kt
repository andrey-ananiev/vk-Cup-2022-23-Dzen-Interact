package ru.keytomyself.dzeninteract.screens.pager

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import ru.keytomyself.dzeninteract.screens.pager.models.PagerIntent
import ru.keytomyself.dzeninteract.screens.pager.models.PagerViewState
import ru.keytomyself.dzeninteract.screens.pager.views.PagerView
import ru.keytomyself.dzeninteract.screens.pager.views.ResultView
import ru.keytomyself.dzeninteract.screens.pager.views.START_COMIC
import ru.keytomyself.dzeninteract.screens.pager.views.StartView

@Composable
fun PagerScreen(
    pagerViewModel: PagerViewModel
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        val viewState = pagerViewModel.pagerViewState.observeAsState()

        when (val state = viewState.value) {
            PagerViewState.PagerStart -> StartView(
                onStartButtonClick = { pagerIndex -> pagerViewModel.obtainIntent(
                    PagerIntent.StartPager(pagerIndex)
                )}
            )
            is PagerViewState.PagerMain -> PagerView(
                state = state,
                onBackClicked = { pagerViewModel.obtainIntent(
                    PagerIntent.BackClicked
                )},
                onPositionChanged = { pagerPos, levelPos -> pagerViewModel.obtainIntent(
                    PagerIntent.PositionChanged(pagerPos, levelPos)
                )},
                onTextChanged = { pagerPos, index, text -> pagerViewModel.obtainIntent(
                    PagerIntent.TextChanged(pagerPos, index, text)
                )},
                onItemDropped = { pagerPos, index, textId -> pagerViewModel.obtainIntent(
                    PagerIntent.ItemDropped(pagerPos, index, textId)
                )},
                onLetterDropped = { pagerPos, index, char -> pagerViewModel.obtainIntent(
                    PagerIntent.LetterDropped(pagerPos, index, char)
                )},
                onLetterReplaced = { pagerPos, index, isToRight -> pagerViewModel.obtainIntent(
                    PagerIntent.LetterReplaced(pagerPos, index, isToRight)
                )},
                onConfirmClick = { pagerPos -> pagerViewModel.obtainIntent(
                    PagerIntent.ConfirmClicked(pagerPos)
                )},
                onRestart = { pagerPos -> pagerViewModel.obtainIntent(
                    PagerIntent.Restart(pagerPos)
                )},
                onCloudDropped = { pagerPos -> pagerViewModel.obtainIntent(
                    PagerIntent.CloudDropped(pagerPos))
                }
            )
            is PagerViewState.PagerResult -> ResultView(state) { pagerViewModel.obtainIntent(
                PagerIntent.BackClicked
            )}
            else -> {}
        }

        LaunchedEffect(key1 = Unit, block = {
            pagerViewModel.obtainIntent(intent = PagerIntent.EnterScreen)
        })
    }
}