package com.example.awesomelanguagelearning.chooseLanguage.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.ChooseLanguageListItem
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.TextTitle

@Composable
fun ListItem(
    itemState: ChooseLanguageListItem,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = getBackgroundColor(itemState.isSelected),
                shape = AppTheme.shapes.large
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemState.icon?.let { icon ->
            Image(
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = itemState.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
        }
        TextTitle(
            text = itemState.title,
            textStyle = AppTheme.typography.bodyBoldL,
            textColor = getTextColor(itemState.isSelected)
        )
    }
}

@Composable
private fun getBackgroundColor(isSelected: Boolean) =
    if (isSelected) AppTheme.colors.greenLight else AppTheme.colors.grayLight

@Composable
private fun getTextColor(isSelected: Boolean) =
    if (isSelected) AppTheme.colors.white else AppTheme.colors.black

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    AppTheme {
        ListItem(
            ChooseLanguageListItem(
                title = "Ukraine",
                icon = R.drawable.ic_flag_ukraine
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemSelectedPreview() {
    AppTheme {
        ListItem(
            ChooseLanguageListItem(
                title = "Ukraine",
                icon = R.drawable.ic_flag_ukraine,
                isSelected = true
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemWithoutImagePreview() {
    AppTheme {
        ListItem(
            ChooseLanguageListItem(
                title = "Ukraine"
            )
        )
    }
}