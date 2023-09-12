package com.example.awesomelanguagelearning.login_signup.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.utils.TextColorData
import com.example.awesomelanguagelearning.core.ui.utils.TextStyleData
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.views.ImageButton
import com.example.awesomelanguagelearning.core.ui.views.TextButton
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.TextWithClickablePart

@Composable
fun Controls(
    buttonText: String,
    regularText: String,
    clickableText: String,
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
            onClick = onButtonClick
        )

        HorizontalSpacer()

        Row(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painterResource(R.drawable.line_with_gaps),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.weight(1f)
            )

            TextTitle(text = stringResource(R.string.or))

            Image(
                painterResource(R.drawable.line_with_gaps),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.weight(1f)
            )
        }

        HorizontalSpacer(16)

        Row(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            val modifier = Modifier
                .background(
                    color = AppTheme.colors.grayLight,
                    shape = AppTheme.shapes.medium
                )
                .weight(1F)
                .height(50.dp)
            ImageButton(
                image = painterResource(id = R.drawable.logo_facebook),
                onClick = onFacebookClick,
                modifier = modifier
            )

            ImageButton(
                image = painterResource(id = R.drawable.logo_google),
                onClick = onGoogleClick,
                modifier = modifier
            )
        }

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