package ru.keytomyself.dzeninteract.screens.pager.views.pages

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel
import ru.keytomyself.dzeninteract.screens.pager.views.PagerConfirmButton

const val BOX_HEIGHT = 600
const val IMAGE_HEIGHT = 350

@Composable
fun ImageCloudView(
    page: PageModel.ImageCloud,
    onCloudDropped: () -> Unit,
    onConfirmClick: () -> Unit,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp)
        .height(BOX_HEIGHT.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(IMAGE_HEIGHT.dp)
                .align(Alignment.TopCenter),
            painter = painterResource(id = page.imageId),
            contentDescription = "comic image",
            contentScale = ContentScale.Crop
        )

        var textLen = 0
        page.cloudList.forEach { cloud ->
            if (stringResource(id = cloud.textId).length > textLen)
                textLen = stringResource(id = cloud.textId).length
        }
        val cloudHeight = 70 + textLen * 2

        var index = -1
        page.cloudList.forEach { cloud ->
            index += if (cloud.isDraggable) 1 else 0
            val offsetX = 5 + index % 2 * 200
            val offsetY = 360 + index / 2 * cloudHeight
            val positionX = if (cloud.isDraggable) offsetX + cloud.cloudXOffset
            else cloud.initXOffset
            val positionY = if (cloud.isDraggable) offsetY + cloud.cloudYOffset
            else cloud.initYOffset

            Box(
                modifier = Modifier
                    .offset(
                        x = positionX.dp,
                        y = positionY.dp
                    )
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragStart = {
                            },
                            onDrag = { change, dragAmount ->
                                change.consume()
                                if (cloud.isDraggable) {
                                    cloud.cloudXOffset += dragAmount.x / density
                                    cloud.cloudYOffset += dragAmount.y / density
                                }
                            },
                            onDragEnd = {
                                if (cloud.cloudYOffset < 0F) {
                                    onCloudDropped()
                                }
                            },
                            onDragCancel = {
                            }
                        )
                    },
            ) {
                Image(
                    modifier = Modifier
                        .size(cloud.tailSize.dp)
                        .align(cloud.tailAlign)
                        .rotate(cloud.tailRotate),
                    painter = painterResource(id = cloud.tailId),
                    contentDescription = "cloud tail",
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceVariant)
                )
                Card(
                    modifier = Modifier
                        .padding(cloud.cloudPadding)
                        .widthIn(min = 50.dp, max = 180.dp),
                    shape = MaterialTheme.shapes.large,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 16.dp),
                        text = stringResource(id = cloud.textId),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        PagerConfirmButton(
            isConfirmButtonVisible = page.isConfirmButtonVisible && page.isLastPage,
            modifier = Modifier.align(Alignment.BottomCenter),
            onConfirmClick = onConfirmClick
        )
    }
}