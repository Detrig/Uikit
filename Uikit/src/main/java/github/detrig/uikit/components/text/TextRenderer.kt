package github.detrig.uikit.components.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import github.detrig.uikit.core.RenderContext
import androidx.core.graphics.toColorInt
import androidx.compose.material3.Text
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.utils.applyStyle

object TextRenderer {

    @Composable
    fun Render(component: TextComponent, state: ScreenState) {
        val value = state.getValue(component.id ?: "")?.toString() ?: component.value

        val color = component.color?.let { Color(it.toColorInt()) } ?: Color.Black
        val fontSize = (component.fontSize ?: 16).sp
        val fontWeight = if (component.bold) FontWeight.Bold else FontWeight.Normal
        val fontStyle = if (component.italic) FontStyle.Normal else FontStyle.Normal

        Text(
            text = value ?: "",
            color = color,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontStyle = fontStyle,
            modifier = Modifier.applyStyle(component.style)
        )
    }
}