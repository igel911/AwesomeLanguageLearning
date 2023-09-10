package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    text: String,
    textStyle: TextStyle = AppTheme.typography.bodyBoldL,
    textColor: Color = AppTheme.colors.white,
    icon: ImageVector? = null,
    iconColor: Color = AppTheme.colors.white,
    onIconClick: () -> Unit = { },
    containerColor: Color = AppTheme.colors.purple,
    titleContentColor: Color = AppTheme.colors.white
    ) {
    CenterAlignedTopAppBar(
        title = {
            TextTitle(
                text = text,
                textStyle = textStyle,
                textColor = textColor
            )
        },
        navigationIcon = {
            if (icon != null) {
                IconButton(onClick = onIconClick) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = iconColor
                    )
                }
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = containerColor,
            titleContentColor = titleContentColor
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ToolbarPreview() {
    AppTheme {
        Toolbar(
            text = "toolbar",
            icon = Icons.Filled.KeyboardArrowLeft
        )
    }
}