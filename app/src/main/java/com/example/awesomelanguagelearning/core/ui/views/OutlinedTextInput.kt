package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholderText: String = "",
    contentDescription: String = "",
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
    //textFieldColors: TextFieldColors = textFieldColors()
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(
            text = placeholderText,
            style = placeholderTextStyle

        ) },
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
        //colors = textFieldColors
    )
}

@Preview(showBackground = true)
@Composable
fun OutlinedTextInputPreview() {
    AppTheme {
        OutlinedTextInput(
            value = "abc",
            onValueChange = { }
        )
    }
}