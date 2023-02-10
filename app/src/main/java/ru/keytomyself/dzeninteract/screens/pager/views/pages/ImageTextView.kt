package ru.keytomyself.dzeninteract.screens.pager.views.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel
import ru.keytomyself.dzeninteract.screens.pager.views.PageInfo

@Composable
fun ImageTextView(
    page: PageModel.ImageTextPage,
) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .clip(MaterialTheme.shapes.large),
        painter = painterResource(id = page.imageId),
        contentDescription = "welcome",
        contentScale = ContentScale.FillWidth
    )
    Divider(
        modifier = Modifier
            .height(18.dp)
            .fillMaxWidth(0.5F)
            .padding(8.dp),
        color = MaterialTheme.colorScheme.primary
    )
    page.textIdList.forEach { textId ->
        Text(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = textId),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = page.textAlign
        )
    }
}