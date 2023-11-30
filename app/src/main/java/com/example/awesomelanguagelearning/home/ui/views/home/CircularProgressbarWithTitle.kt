package com.example.awesomelanguagelearning.home.ui.views.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.TextTitle

@Composable
fun CircularProgressbarWithTitle(
    number: Int,
    maxNumber: Int,
    isSelected: Boolean = false,
    size: Dp = 120.dp,
    indicatorThickness: Dp = 12.dp
) {
    val circleRadius = size - indicatorThickness
    val backgroundIndicatorColor = getBackgroundIndicatorColor(isSelected)
    val foregroundIndicatorColor = getForegroundIndicatorColor(isSelected)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(size = size)
    ) {
        Canvas(
            modifier = Modifier.size(size = circleRadius)
        ) {

            drawCircle(
                color = backgroundIndicatorColor,
                radius = circleRadius.toPx() / 2,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round)
            )

            val sweepAngle = (number.toFloat() / maxNumber) * 360 * -1

            drawArc(
                color = foregroundIndicatorColor,
                startAngle = 90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(indicatorThickness.toPx(), cap = StrokeCap.Round)
            )
        }

        TextTitle(
            text = stringResource(R.string.completed_course, number, maxNumber),
            textStyle = AppTheme.typography.h6,
            textColor = getTextColor(isSelected)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CircularProgressbarWithTitlePreview() {
    AppTheme {
        CircularProgressbarWithTitle(
            number = 15,
            maxNumber = 30
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun SelectedCircularProgressbarWithTitlePreview() {
    AppTheme {
        CircularProgressbarWithTitle(
            number = 15,
            maxNumber = 30,
            isSelected = true
        )
    }
}

@Composable
private fun getTextColor(isSelected: Boolean): Color =
    if (isSelected) AppTheme.colors.white else AppTheme.colors.black

@Composable
private fun getForegroundIndicatorColor(isSelected: Boolean): Color =
    if (isSelected) AppTheme.colors.greenLight.copy(alpha = 0.5f) else AppTheme.colors.orange

@Composable
private fun getBackgroundIndicatorColor(isSelected: Boolean): Color =
    if (isSelected) AppTheme.colors.white else AppTheme.colors.orange.copy(alpha = 0.2f)