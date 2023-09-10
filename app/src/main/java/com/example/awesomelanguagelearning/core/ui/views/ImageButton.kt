package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@Composable
fun ImageButton(
    image: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,

    ) {
    Box(
        modifier = modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(bounded = true, color = AppTheme.colors.grayMedium)
            ) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        ImageButton(
            image = painterResource(id = R.drawable.logo_google),
            onClick = { },
            modifier = Modifier.background(
                color = AppTheme.colors.grayLight,
                shape = AppTheme.shapes.medium
            ).width(150.dp).height(50.dp)
        )
    }
}