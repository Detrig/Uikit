package github.detrig.uikit.components.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import github.detrig.uikit.components.button.ButtonComponent
import github.detrig.uikit.components.button.ButtonRenderer
import github.detrig.uikit.components.image.ImageComponent
import github.detrig.uikit.components.image.ImageRenderer
import github.detrig.uikit.components.text.TextComponent
import github.detrig.uikit.components.text.TextRenderer
import github.detrig.uikit.core.ActionDispatcher

object ScreenRenderer {
    @Composable
    fun Render(screenModel: ScreenModel, state: ScreenState, dispatcher: ActionDispatcher) {
        Column {
            screenModel.components.forEach { component ->
                when (component) {
                    is TextComponent -> TextRenderer.Render(component, state)
                    is ButtonComponent -> ButtonRenderer.Render(component, dispatcher)
                    is ImageComponent -> ImageRenderer.Render(component)
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}