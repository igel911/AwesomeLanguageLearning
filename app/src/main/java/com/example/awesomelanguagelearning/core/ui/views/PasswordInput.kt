package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.models.ValidationResult
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholderText: String = "",
    contentDescription: String = stringResource(R.string.password),
    validationResult: ValidationResult = ValidationResult.valid(),
    placeholderTextStyle: TextStyle = AppTheme.typography.bodyS,
    shape: Shape = AppTheme.shapes.medium,
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
    var showPassword by remember { mutableStateOf(false) }

    TextInput(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle,
        placeholderText = placeholderText,
        placeholderTextStyle = placeholderTextStyle,
        visualTransformation = getCorrectPasswordTransformation(showPassword),
        icon = getCorrectPasswordImage(showPassword),
        contentDescription = contentDescription,
        onIconClick = { showPassword = !showPassword },
        singleLine = singleLine,
        maxLines = maxLines,
        keyboardOptions = keyboardOptions,
        textFieldColors = textFieldColors,
        shape = shape,
        validationResult = validationResult
    )
}

@Composable
private fun getCorrectPasswordTransformation(showPassword: Boolean) =
    if (showPassword) VisualTransformation.None else PasswordVisualTransformation()

@Composable
private fun getCorrectPasswordImage(showPassword: Boolean) = if (showPassword) {
    Icons.Filled.VisibilityOff
} else {
    Icons.Outlined.Visibility
}

@Preview(showBackground = true)
@Composable
fun PasswordInputPreview() {
    AppTheme {
        PasswordInput(
            value = "abc",
            onValueChange = { }
        )
    }
}
