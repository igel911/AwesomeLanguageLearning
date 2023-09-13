package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@Composable
fun PasswordInputWithTitle(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    titleText: String = stringResource(R.string.password),
    placeholderText: String = ""
) {
    Column(modifier = modifier) {
        TextTitle(
            text = titleText,
            textStyle = AppTheme.typography.bodyM
        )

        HorizontalSpacer()

        PasswordInput(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            placeholderText = placeholderText
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordInputWithTitlePreview() {
    AppTheme {
        PasswordInputWithTitle(
            value = "abc",
            titleText = "title",
            onValueChange = { }
        )
    }
}