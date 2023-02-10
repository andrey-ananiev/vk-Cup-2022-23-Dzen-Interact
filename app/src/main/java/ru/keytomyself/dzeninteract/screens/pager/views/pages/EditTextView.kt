package ru.keytomyself.dzeninteract.screens.pager.views.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.keytomyself.dzeninteract.R
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel.EditText.Companion.NOTE
import ru.keytomyself.dzeninteract.screens.pager.models.PageModel.EditText.Companion.TOPIC

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextView(
    page: PageModel.EditText,
    onTextChanged: (Int, String) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        value = page.topic,
        onValueChange = { onTextChanged(TOPIC, it) },
        shape = MaterialTheme.shapes.large,
        label = { Text(
            text = stringResource(id = R.string.page_note_topic_label),
            style = MaterialTheme.typography.bodySmall
        )},
        singleLine = true
    )
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .defaultMinSize(minHeight = 300.dp),
        value = page.note,
        onValueChange = { onTextChanged(NOTE, it) },
        shape = MaterialTheme.shapes.large,
        label = { Text(
            text = stringResource(id = R.string.page_note_text_label),
            style = MaterialTheme.typography.bodySmall
        )}
    )
}