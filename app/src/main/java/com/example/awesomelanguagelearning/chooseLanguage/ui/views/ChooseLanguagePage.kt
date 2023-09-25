package com.example.awesomelanguagelearning.chooseLanguage.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.ChooseLanguageListItem
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.ChooseLanguagePageState
import com.example.awesomelanguagelearning.chooseLanguage.ui.utils.ChooseLanguagePageParameterProvider
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.views.TextButton
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import java.util.UUID

@Composable
fun ChooseLanguagePage(
    state: ChooseLanguagePageState,
    onNextClick: () -> Unit = {},
    onItemClick: (UUID) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalSpacer()

        TextTitle(
            text = state.title,
            textStyle = AppTheme.typography.h5
        )

        HorizontalSpacer()

        LazyColumn(
            modifier = Modifier.weight(1F),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items = state.items, key = ChooseLanguageListItem::id) { item ->
                ListItem(
                    itemState = item,
                    modifier = Modifier.clickable { onItemClick(item.id) }
                )
            }
        }

        HorizontalSpacer(4)

        TextButton(
            text = stringResource(R.string.next),
            modifier = Modifier.fillMaxWidth(),
            onClick = onNextClick
        )

        HorizontalSpacer()
    }
}

@Preview(showBackground = true)
@Composable
fun ChooseLanguagePagePreview(
    @PreviewParameter(ChooseLanguagePageParameterProvider::class)
    state: ChooseLanguagePageState
) {
    AppTheme {
        ChooseLanguagePage(state)
    }
}