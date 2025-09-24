package github.detrig.uikit.components.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import github.detrig.uikit.core.ActionDispatcher
import github.detrig.uikit.core.RenderContext
import github.detrig.uikit.utils.applyStyle

object ButtonRenderer {

    @Composable
    fun Render(component: ButtonComponent, actionDispatcher: ActionDispatcher) {
        val text = component.text
        val textColor = component.textColor?.let { Color(it.toColorInt()) } ?: Color.Black
        val fontSize = (component.fontSize ?: 16).sp
        val fontWeight = if (component.bold) FontWeight.Bold else FontWeight.Normal

        val backgroundColor = component.backgroundHex?.let { Color(it.toColorInt()) }
            ?: MaterialTheme.colorScheme.primary

        var modifier = Modifier


        Button(
            colors = ButtonDefaults.buttonColors(contentColor = backgroundColor),
            modifier = Modifier.applyStyle(component.style),
            onClick = {
                component.action?.let { actionDispatcher.dispatch(it) }
            }) {
            text?.let {
                if (text.isNotEmpty()) {
                    Text(
                        text = text,
                        color = textColor,
                        fontSize = fontSize,
                        fontWeight = fontWeight
                    )
                }
            }
        }

    }
}