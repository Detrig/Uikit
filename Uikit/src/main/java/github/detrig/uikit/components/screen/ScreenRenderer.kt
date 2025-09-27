package github.detrig.uikit.components.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.util.Log
import androidx.compose.ui.graphics.Color
import github.detrig.uikit.components.box.BoxComponent
import github.detrig.uikit.components.box.BoxRenderer.Render
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

object ScreenRenderer {
    @Composable
    fun Render(component: ScreenComponent, state: ScreenState) {
        val backgroundColor = component.background?.let {
            Color(android.graphics.Color.parseColor(it))
        } ?: Color.White

        Scaffold(
            topBar = {
                if (component.topBar.isNotEmpty()) {
                    Column(Modifier.fillMaxWidth().background(backgroundColor)) {
                        component.topBar.forEach { RenderComponent(it, state) }
                    }
                }
            },
            bottomBar = {
                if (component.bottomBar.isNotEmpty()) {
                    Column(Modifier.fillMaxWidth().background(backgroundColor)) {
                        component.bottomBar.forEach { RenderComponent(it, state) }
                    }
                }
            },
            containerColor = backgroundColor
        ) { paddingValues ->
            Column(Modifier.padding(paddingValues)) {
                component.content.forEach { RenderComponent(it, state) }
            }
        }
    }
}

@Composable
fun RenderComponent(component: Component, state: ScreenState) {
    Log.d("alz-04", "component: $component")
    when (component) {
        is TextComponent -> TextRenderer.Render(component, state)
        is ButtonComponent -> ButtonRenderer.Render(component, state)
        is ImageComponent -> ImageRenderer.Render(component, state)
        is IconComponent -> IconRenderer.Render(component)
        is CheckboxComponent -> CheckboxRenderer.Render(component, state)
        is RowComponent -> RowRenderer.Render(component, state)
        is BoxComponent -> Render(component, state)
        is ColumnComponent -> ColumnRenderer.Render(component, state)
        is CardComponent -> CardRenderer.Render(component, state)
        else -> {
            println("Unknown component type: ${component::class.simpleName}")
        }
    }
}