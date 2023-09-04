package com.example.awesomelanguagelearning.paging.ui.views

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@Composable
fun TitleLogin(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit = { }
) {
    val alreadyMember = stringResource(id = R.string.already_member)
    val login = stringResource(id = R.string.login)

    val annotatedText = buildAnnotatedString {
        withStyle(style = regularStyle()) {
            append(alreadyMember)
            append(" ")
        }

        withStyle(style = clickableStyle()) {
            pushStringAnnotation(
                tag = login,
                annotation = login
            )
            append(login)
        }
    }

    ClickableText(
        modifier = modifier,
        text = annotatedText,
        style = TextStyle(textAlign = TextAlign.Center),
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = login,
                start = offset,
                end = offset
            ).firstOrNull()?.let { onLoginClick() }
        }
    )
}

@Composable
private fun regularStyle() = SpanStyle(
    color = AppTheme.colors.grayMedium,
    fontStyle = AppTheme.typography.bodyM.fontStyle,
    fontSize = AppTheme.typography.bodyM.fontSize
)

@Composable
private fun clickableStyle() = SpanStyle(
    color = AppTheme.colors.black,
    fontStyle = AppTheme.typography.bodyBoldM.fontStyle,
    fontSize = AppTheme.typography.bodyBoldM.fontSize,
    fontWeight = AppTheme.typography.bodyBoldM.fontWeight
)

@Preview(showBackground = true)
@Composable
fun TitleLoginPreview() {
    AppTheme {
        TitleLogin()
    }
}