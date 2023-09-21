package com.example.awesomelanguagelearning.home.ui.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.home.ui.MainNavigation


@Composable
fun MainBottomBarItem(
    screen: MainNavigation,
    selected: Boolean,
    onClick: () -> Unit = {}
) {
    val background = if (selected) AppTheme.colors.blueDark else Color.Transparent
    val contentColor = if (selected) AppTheme.colors.white else AppTheme.colors.grayMedium

    Row(
        modifier = Modifier
            .background(
                color = background,
                shape = AppTheme.shapes.medium
            )
            .padding(all = 12.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            imageVector = if (selected) screen.selectedIcon else screen.unselectedIcon,
            contentDescription = screen.route,
            tint = contentColor
        )
        AnimatedVisibility(visible = selected) {
            TextTitle(
                text = screen.route,
                textStyle = AppTheme.typography.bodyS,
                textColor = contentColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddItemSelectedPreview() {
    AppTheme {
        MainBottomBarItem(
            screen = MainNavigation.Home,
            selected = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddItemPreview() {
    AppTheme {
        MainBottomBarItem(
            screen = MainNavigation.Home,
            selected = false
        )
    }
}