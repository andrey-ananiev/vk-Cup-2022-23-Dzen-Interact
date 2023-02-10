package ru.keytomyself.dzeninteract.screens.pager.views

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.R

@Composable
fun PagerConfirmButton(
    isConfirmButtonVisible: Boolean,
    modifier: Modifier,
    onConfirmClick: () -> Unit
) {
    Row(
        modifier = modifier.padding(horizontal = 100.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = isConfirmButtonVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Button(onClick = { onConfirmClick() }) {
                Text(
                    modifier = Modifier.padding(vertical = 6.dp),
                    text = stringResource(id = R.string.pager_confirm),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}