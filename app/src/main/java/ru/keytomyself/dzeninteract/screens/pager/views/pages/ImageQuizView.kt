package ru.keytomyself.dzeninteract.screens.pager.views.pages

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel
import ru.keytomyself.dzeninteract.screens.pager.views.PagerConfirmButton
import ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop.DragForSwap
import ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop.DraggableTextItem
import ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop.DropTarget

const val LETTER_WIDTH = 55
const val QUIZ_IMAGE_HEIGHT = 370

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ImageQuizView(
    page: PageModel.ImageQuiz,
    onLetterDropped: (Int, Char) -> Unit,
    onLetterReplaced: (Int, Boolean) -> Unit,
    onConfirmClick: () -> Unit,
    onRestart: () -> Unit
) {
    LaunchedEffect(key1 = Unit) { onRestart() }

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(QUIZ_IMAGE_HEIGHT.dp)
    ) {
        val imageId = if (page.keyImageId != null && page.isCorrect == true) page.keyImageId
        else page.imageId
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = imageId),
            contentDescription = "quiz image",
            contentScale = ContentScale.FillWidth
        )

        PagerConfirmButton(
            isConfirmButtonVisible = page.isConfirmButtonVisible && page.isCorrect != true,
            modifier = Modifier.align(Alignment.Center),
            onConfirmClick = onConfirmClick
        )
        val isCorrect = page.isCorrect == true
        AnimatedVisibility(
            modifier = Modifier
                .align(Alignment.Center),
            visible = isCorrect,
            enter = scaleIn(
                animationSpec = tween(200),
                initialScale = 0.3f,
                transformOrigin = TransformOrigin(0.5f, 0.2f)
            ),
            exit = scaleOut(
                animationSpec = tween(200),
                transformOrigin = TransformOrigin(0.5f, 0.2f)
            )
        ) {
            val animation = remember { Animatable(0F) }

            LaunchedEffect (key1 = isCorrect) {
                animationCorrect(
                    animation = animation,
                    isCorrect = isCorrect,
                    amplitude = 6F,
                    duration = 200,
                    delay = 200,
                    repeat = 1
                )
            }
            Image(
                modifier = Modifier
                    .size((200 + animation.value).dp)
                    .padding(bottom = 50.dp),
                painter = painterResource(id = R.drawable.correct),
                contentDescription = "quiz correct",
                contentScale = ContentScale.Inside
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            DragForSwap(
                itemList = page.targetLetterList,
                orientation = Orientation.Horizontal,
                itemSize = LETTER_WIDTH,
                onLetterReplaced = onLetterReplaced
            ) { modifier, index, _ ->
                DropTarget<Char>(
                    modifier = modifier,
                ) { isInBound, isDropped, data ->
                    if (isDropped) onLetterDropped(index, data!!)
                    TargetItem(
                        text = page.targetLetterList[index],
                        isInBound = isInBound,
                        isCorrect = page.isCorrect,
                        index = index
                    )
                }
            }
        }
    }

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 16.dp),
        mainAxisAlignment = FlowMainAxisAlignment.Center
    ) {
        page.sourceLetterList.forEach { letter ->
            DraggableTextItem(
                text = letter,
            )
        }
    }
}

@Composable
fun TargetItem(
    text: Char,
    isInBound: Boolean = false,
    isCorrect: Boolean? = null,
    index: Int
) {
    val animation = remember { Animatable(0F) }

    val border = when (isCorrect) {
        true -> BorderStroke(3.dp, MaterialTheme.colorScheme.primary)
        false -> BorderStroke(3.dp, MaterialTheme.colorScheme.error)
        null -> null
    }

    LaunchedEffect (key1 = isCorrect) {
        val amplitude = if(isCorrect == true) 4F else 1F
        val duration = if(isCorrect == true) 120 else 2
        val repeat = if(isCorrect == true) 3 else 10
        val delay = if(isCorrect == true) index * 30 else 0
        animationCorrect(
            animation = animation,
            isCorrect = isCorrect,
            amplitude = amplitude,
            duration = duration,
            delay = delay,
            repeat = repeat
        )
    }
    val modifier = when (isCorrect) {
        true -> Modifier.offset(y = animation.value.dp)
        false -> Modifier.offset(x = animation.value.dp)
        null -> Modifier
    }
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = if (isCorrect != false) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.error
        ),
        border = if (isInBound && isCorrect == null) BorderStroke(3.dp, MaterialTheme.colorScheme.primary)
        else border
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = if (text == ' ') 20.dp else 16.dp),
            text = text.toString(),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = if (isCorrect == true) FontWeight.Bold else FontWeight.Normal,
        )
    }
}

suspend fun animationCorrect(
    animation: Animatable<Float, AnimationVector1D>,
    isCorrect: Boolean?,
    amplitude: Float,
    delay: Int,
    duration: Int,
    repeat: Int
) {
    when(isCorrect) {
        false, true -> {
            animation.animateTo(
                targetValue = amplitude,
                animationSpec = tween(
                    delayMillis = delay,
                    durationMillis = duration
                )
            )
            for(i in 0..repeat) {
                val target = if (i % 2 == 0) -amplitude * 2 else amplitude * 2
                animation.animateTo(
                    targetValue = target,
                    animationSpec = tween(durationMillis = duration * 2)
                )
            }
            animation.animateTo(
                targetValue = -amplitude,
                animationSpec = tween(durationMillis = duration)
            )
        }
        null -> { }
    }
}