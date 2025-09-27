package github.detrig.uikit.components.column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import github.detrig.uikit.components.box.BoxComponent
import github.detrig.uikit.components.box.BoxRenderer
import github.detrig.uikit.components.checkbox.CheckboxComponent
import github.detrig.uikit.components.button.ButtonComponent
import github.detrig.uikit.components.button.ButtonRenderer
import github.detrig.uikit.components.card.CardComponent
import github.detrig.uikit.components.card.CardRenderer
import github.detrig.uikit.components.checkbox.CheckboxRenderer
import github.detrig.uikit.components.icon.IconComponent
import github.detrig.uikit.components.icon.IconRenderer
import github.detrig.uikit.components.image.ImageComponent
import github.detrig.uikit.components.image.ImageRenderer
import github.detrig.uikit.components.row.RowComponent
import github.detrig.uikit.components.row.RowRenderer
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.components.spacer.SpacerComponent
import github.detrig.uikit.components.text.TextComponent
import github.detrig.uikit.components.text.TextRenderer
import github.detrig.uikit.components.utils.toComposeModifier

object ColumnRenderer {

    @Composable
    fun Render(component: ColumnComponent, state: ScreenState) {
        Column(
            modifier = component.modifier?.toComposeModifier() ?: Modifier,
            verticalArrangement = when (component.verticalArrangement) {
                "top" -> Arrangement.Top
                "center" -> Arrangement.Center
                "bottom" -> Arrangement.Bottom
                "spaceBetween" -> Arrangement.SpaceBetween
                "spaceAround" -> Arrangement.SpaceAround
                "spaceEvenly" -> Arrangement.SpaceEvenly
                else -> Arrangement.Top
            },
            horizontalAlignment = when (component.horizontalAlignment) {
                "start" -> Alignment.Start
                "center" -> Alignment.CenterHorizontally
                "end" -> Alignment.End
                else -> Alignment.Start
            }
        ) {
            component.children.forEach { child ->
                when (child) {
                    is TextComponent -> TextRenderer.Render(child, state)
                    is ButtonComponent -> ButtonRenderer.Render(child, state)
                    is ImageComponent -> ImageRenderer.Render(child, state)
                    is RowComponent -> RowRenderer.Render(child, state)
                    is ColumnComponent -> Render(child, state) // рекурсивно
                    is CheckboxComponent -> CheckboxRenderer.Render(child, state)
                    is SpacerComponent -> {
                        val baseModifier = child.modifier?.toComposeModifier() ?: Modifier
                        val finalModifier = child.modifier?.weight?.let { w ->
                            baseModifier.then(Modifier.weight(w))
                        } ?: baseModifier
                        Spacer(modifier = finalModifier)
                    }
                    is CardComponent -> CardRenderer.Render(child, state)
                    is BoxComponent -> BoxRenderer.Render(child, state)
                    is IconComponent -> IconRenderer.Render(child)
                    else -> {}
                }
            }
        }
    }
}
