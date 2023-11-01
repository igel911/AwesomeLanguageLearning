package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.core.ui.models.ValidationResult
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@Composable
fun TextInputWithTitle(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    labelText: String = "",
    validationResult: ValidationResult = ValidationResult.valid(),
    labelTextStyle: TextStyle = AppTheme.typography.bodyM,
    placeholderText: String = "",
    placeholderTextStyle: TextStyle = AppTheme.typography.bodyM,
    textColor: Color = AppTheme.colors.grayMedium,
    shape: Shape = AppTheme.shapes.medium
) {
    Column(modifier = modifier) {
        TextTitle(
            text = labelText,
            textStyle = labelTextStyle
        )

        HorizontalSpacer()

        TextInput(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            placeholderText = placeholderText,
            placeholderTextStyle = placeholderTextStyle,
            shape = shape,
            textColor = textColor,
            validationResult = validationResult

        )
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedTextInputWithTitlePreview() {
    AppTheme {
        TextInputWithTitle(
            value = "abc",
            labelText = "label",
            onValueChange = { }
        )
    }
}