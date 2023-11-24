package com.example.awesomelanguagelearning.home.ui.views.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.TextTitle

@Composable
fun HomeToolbar(
    username: String,
    onUserIconClick: () -> Unit = { },
    onActionIconClick: () -> Unit = { }
) {
    val colors = AppTheme.colors

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.purple)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_pfp),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .border(
                        BorderStroke(4.dp, colors.white),
                        CircleShape
                    )
                    .clip(CircleShape)
                    .clickable { onUserIconClick() }
            )

            Image(
                imageVector = Icons.Outlined.Notifications,
                colorFilter = ColorFilter.tint(colors.white),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .clickable { onActionIconClick() }
            )
        }

        TextTitle(
            text = stringResource(id = R.string.hello_username, username),
            textStyle = AppTheme.typography.h4,
            textColor = colors.white
        )

        TextTitle(
            text = stringResource(id = R.string.what_would_you_like),
            textColor = colors.white
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppTheme {
        HomeToolbar(username = "Filllo")
    }
}