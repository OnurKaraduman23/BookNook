package com.onuryasarkaraduman.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.R

@Composable
fun NextButton(
    text: String,
    textColor: Color,
    textFontWeight: FontWeight = FontWeight.Bold,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(26.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.yellow),
            contentColor = Color.Red,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Black
        ),
        enabled = isEnabled,
        shape = CutCornerShape(12.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 24.dp,
            disabledElevation = 8.dp
        ),
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor,
            fontWeight = textFontWeight
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NextButtonPreview() {
    NextButton(
        text = stringResource(R.string.next),
        textColor = colorResource(id = R.color.black),
        onClick = {}
    )
}
