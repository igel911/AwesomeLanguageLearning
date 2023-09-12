package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@Composable
fun LoginVariants(
    onFacebookClick: () -> Unit,
    onGoogleClick: () -> Unit,
    modifier: Modifier = Modifier,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    horizontalArrangement: Arrangement.HorizontalOrVertical = Arrangement.spacedBy(15.dp)
) {
    Row(
        modifier = modifier,
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement
    ) {
        val buttonModifier = Modifier
            .background(
                color = AppTheme.colors.grayLight,
                shape = AppTheme.shapes.medium
            )
            .weight(1F)
            .height(50.dp)
        ImageButton(
            image = painterResource(id = R.drawable.logo_facebook),
            onClick = onFacebookClick,
            modifier = buttonModifier
        )

        ImageButton(
            image = painterResource(id = R.drawable.logo_google),
            onClick = onGoogleClick,
            modifier = buttonModifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginVariantsPreview() {
    AppTheme {
        LoginVariants(
            onFacebookClick = {},
            onGoogleClick = {}
        )
    }
}