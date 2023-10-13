package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.utils.TextColorData
import com.example.awesomelanguagelearning.core.ui.utils.TextStyleData

@Composable
fun Controls(
    buttonText: String,
    regularText: String,
    clickableText: String,
    isButtonEnabled: Boolean = false,
    onButtonClick: () -> Unit = { },
    onFacebookClick: () -> Unit = { },
    onGoogleClick: () -> Unit = { },
    onClickableTextClick: () -> Unit = { }
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(
            text = buttonText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            onClick = onButtonClick,
            isButtonEnabled = isButtonEnabled
        )

        HorizontalSpacer()

        SeparatorWithText(modifier = Modifier.padding(horizontal = 24.dp))

        HorizontalSpacer(16)

        LoginVariants(
            onFacebookClick = onFacebookClick,
            onGoogleClick = onGoogleClick,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        HorizontalSpacer(16)

        TextWithClickablePart(
            regularText = regularText,
            clickableText = clickableText,
            onClick = onClickableTextClick,
            textColorData = TextColorData(
                regular = AppTheme.colors.grayDark,
                clickable = AppTheme.colors.blueDark
            ),
            textStyleData = TextStyleData(
                regular = AppTheme.typography.bodyL,
                clickable = AppTheme.typography.bodyBoldL
            )
        )

        HorizontalSpacer(16)
    }
}

@Preview(showBackground = true)
@Composable
fun ControlsPreview() {
    AppTheme {
        Controls(
            buttonText = stringResource(R.string.login_title),
            regularText = stringResource(R.string.not_member),
            clickableText = stringResource(R.string.signup_title)
        )
    }
}