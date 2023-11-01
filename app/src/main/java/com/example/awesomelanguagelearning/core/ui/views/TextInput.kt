package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.core.ui.models.ValidationResult
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholderText: String = "",
    contentDescription: String = "",
    validationResult: ValidationResult = ValidationResult.valid(),
    placeholderTextStyle: TextStyle = AppTheme.typography.bodyS,
    shape: Shape = AppTheme.shapes.medium,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    icon: ImageVector? = null,
    onIconClick: () -> Unit = {},
    singleLine: Boolean = true,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.None
    ),
    textStyle: TextStyle = TextStyle(textAlign = TextAlign.Start),
    textColor: Color = AppTheme.colors.black,
    textFieldColors: TextFieldColors = TextFieldDefaults.textFieldColors(
        textColor = textColor,
        placeholderColor = textColor,
        containerColor = AppTheme.colors.grayLight,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent

    )
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeholderText,
                    style = placeholderTextStyle

                )
            },
            shape = shape,
            visualTransformation = visualTransformation,
            trailingIcon = {
                if (icon != null) {
                    IconButton(onClick = onIconClick) {
                        Icon(
                            imageVector = icon,
                            contentDescription = contentDescription
                        )
                    }
                }
            },
            singleLine = singleLine,
            maxLines = maxLines,
            keyboardOptions = keyboardOptions,
            textStyle = textStyle,
            colors = textFieldColors,
            isError = !validationResult.isValid,
        )
        if (!validationResult.isValid) {
            Text(
                text = validationResult.errorMessage.orEmpty(),
                color = AppTheme.colors.red,
                modifier = Modifier.align(Alignment.Start)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedTextInputPreview() {
    AppTheme {
        TextInput(
            value = "abc",
            onValueChange = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedTextInputErrorPreview() {
    AppTheme {
        TextInput(
            value = "abc",
            onValueChange = { },
            validationResult = ValidationResult(
                isValid = false,
                errorMessage = "Houston, we have a problem"
            )
        )
    }
}