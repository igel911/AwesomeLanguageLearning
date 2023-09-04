package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme


@Composable
fun TextButton(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AppTheme.typography.h6,
    shape: Shape = AppTheme.shapes.medium,
    defaultElevation: Dp = 10.dp,
    pressedElevation: Dp = 15.dp,
    disabledElevation: Dp = 0.dp,
    containerColor: Color = AppTheme.colors.blueDark,
    isButtonEnabled: Boolean = true,
    onClick: () -> Unit = { }
) {
    Button(
        modifier = modifier,
        shape = shape,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = defaultElevation,
            pressedElevation = pressedElevation,
            disabledElevation = disabledElevation
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor
        ),
        enabled = isButtonEnabled,
        onClick = onClick
    ) {
        Text(
            text = text,
            fontSize = textStyle.fontSize,
            fontStyle = textStyle.fontStyle,
            fontWeight = textStyle.fontWeight,
            fontFamily = textStyle.fontFamily
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextButtonPreview() {
    AppTheme {
        TextButton(text = "click me")
    }
}