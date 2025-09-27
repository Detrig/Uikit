package github.detrig.uikit.components.icon

import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import github.detrig.uikit.R
import github.detrig.uikit.components.utils.toComposeModifier
import java.util.Locale


object IconRenderer {

    @Composable
    fun Render(component: IconComponent) {
        val modifier: Modifier = component.modifier?.toComposeModifier() ?: Modifier

        val iconName = component.icon?.lowercase(Locale.getDefault())
        val vector: ImageVector? = when (iconName) {
            "home" -> Icons.Default.Home
            "settings" -> Icons.Default.Settings
            "info" -> Icons.Default.Info
            "favorite" -> Icons.Default.Favorite
            else -> null
        }

        // Определяем цвет (если указан)
        val tintColor = component.tint?.let { Color(android.graphics.Color.parseColor(it)) } ?: Color.Unspecified

        if (vector != null) {
            Icon(
                imageVector = vector,
                contentDescription = component.contentDescription,
                modifier = modifier,
                tint = tintColor
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = component.contentDescription,
                modifier = modifier,
                tint = tintColor
            )
        }
    }
}