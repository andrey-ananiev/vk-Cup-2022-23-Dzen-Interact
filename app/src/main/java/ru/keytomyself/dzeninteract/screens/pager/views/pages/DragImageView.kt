package ru.keytomyself.dzeninteract.screens.pager.views.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel
import ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop.DropTarget
import ru.keytomyself.dzeninteract.screens.pager.views.dragAndDrop.DragTarget

@Composable
fun DragImageView(
    page: PageModel.DragImage,
    onImageDropped: (Int, Int) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        TargetImageItem(
            modifier = Modifier.fillMaxWidth(0.5F),
            imageId = page.chosenImageIdList[0],
            onImageDropped = {onImageDropped(0, it)}
        )
        TargetImageItem(
            modifier = Modifier.fillMaxWidth(),
            imageId = page.chosenImageIdList[1],
            onImageDropped = {onImageDropped(1, it)}
        )
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        TargetImageItem(
            modifier = Modifier.fillMaxWidth(0.5F),
            imageId = page.chosenImageIdList[2],
            onImageDropped = {onImageDropped(2, it)}
        )
        TargetImageItem(
            modifier = Modifier.fillMaxWidth(),
            imageId = page.chosenImageIdList[3],
            onImageDropped = {onImageDropped(3, it)}
        )
    }

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 16.dp),
        mainAxisAlignment = FlowMainAxisAlignment.Center
    ) {
        page.imageIdList.forEach { imageId ->
            DragTarget(
                modifier = Modifier
                    .fillMaxWidth(0.25F)
                    .padding(8.dp),
                dataToDrop = imageId,
            ) {
                Card(
                    shape = MaterialTheme.shapes.medium,
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Image(
                        painter = painterResource(id = imageId),
                        contentDescription = "image"
                    )
                }
            }
        }
    }
}

@Composable
fun TargetImageItem(
    modifier: Modifier,
    imageId: Int,
    onImageDropped: (Int) -> Unit
) {
    DropTarget<Int>(
        modifier = Modifier
    ) { isInBound, isDropped, data ->
        if (isDropped) onImageDropped(data!!)
        Image(
            modifier = modifier
                .border(BorderStroke(if (isInBound) 3.dp else 1.dp, if (isInBound) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.surfaceVariant)),
            painter = painterResource(id = imageId),
            contentDescription = "image",
            contentScale = ContentScale.FillWidth
        )
    }
}