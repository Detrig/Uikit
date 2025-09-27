package github.detrig.uikit.components.box

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import github.detrig.uikit.components.utils.toComposeModifier
import github.detrig.uikit.components.checkbox.CheckboxComponent
import github.detrig.uikit.components.button.ButtonComponent
import github.detrig.uikit.components.button.ButtonRenderer
import github.detrig.uikit.components.card.CardComponent
import github.detrig.uikit.components.card.CardRenderer
import github.detrig.uikit.components.checkbox.CheckboxRenderer
import github.detrig.uikit.components.column.ColumnComponent
import github.detrig.uikit.components.column.ColumnRenderer
import github.detrig.uikit.components.icon.IconComponent
import github.detrig.uikit.components.icon.IconRenderer
import github.detrig.uikit.components.image.ImageComponent
import github.detrig.uikit.components.image.ImageRenderer
import github.detrig.uikit.components.lazycolumn.LazyColumnComponent
import github.detrig.uikit.components.row.RowComponent
import github.detrig.uikit.components.row.RowRenderer
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.components.spacer.SpacerComponent
import github.detrig.uikit.components.text.TextComponent
import github.detrig.uikit.components.text.TextRenderer
import github.detrig.uikit.components.utils.Component


object BoxRenderer {

    @Composable
    fun Render(component: BoxComponent, state: ScreenState) {
        Box(modifier = component.modifier?.toComposeModifier() ?: Modifier) {
            component.children.forEach { child ->
                when (child) {
                    is TextComponent -> TextRenderer.Render(child, state)
                    is ButtonComponent -> ButtonRenderer.Render(child, state)
                    is ImageComponent -> ImageRenderer.Render(child, state)
                    is RowComponent -> RowRenderer.Render(child, state)
                    is ColumnComponent -> ColumnRenderer.Render(child, state)
                    is CheckboxComponent -> CheckboxRenderer.Render(child, state)
                    is CardComponent -> CardRenderer.Render(child, state)
                    is IconComponent -> IconRenderer.Render(child)
                    is BoxComponent -> Render(child, state)
                    else -> {}
                }
            }
        }
    }
}