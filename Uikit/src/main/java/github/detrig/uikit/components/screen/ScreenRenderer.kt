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
import github.detrig.uikit.core.ActionDispatcher
import androidx.core.graphics.toColorInt
import github.detrig.uikit.components.bottomsheet.BottomSheetComponent
import github.detrig.uikit.components.bottomsheet.BottomSheetRenderer
import github.detrig.uikit.components.snackbar.SnackbarComponent
import github.detrig.uikit.components.snackbar.SnackbarRenderer
import github.detrig.uikit.components.textfield.TextFieldComponent
import github.detrig.uikit.components.textfield.TextFieldRenderer
import github.detrig.uikit.core.RenderComponent

object ScreenRenderer {
    @Composable
    fun Render(component: ScreenComponent, state: ScreenState, dispatcher: ActionDispatcher) {
        val backgroundColor = component.background?.let {
            Color(it.toColorInt())
        } ?: Color.White

        Scaffold(
            topBar = {
                if (component.topBar.isNotEmpty()) {
                    Column(Modifier.fillMaxWidth().background(backgroundColor)) {
                        component.topBar.forEach { RenderComponent(it, state, dispatcher) }
                    }
                }
            },
            bottomBar = {
                if (component.bottomBar.isNotEmpty()) {
                    Column(Modifier.fillMaxWidth().background(backgroundColor)) {
                        component.bottomBar.forEach { RenderComponent(it, state, dispatcher) }
                    }
                }
            },
            snackbarHost = {
                Column {
                    component.snackbars.forEach { snackbar ->
                        RenderComponent(snackbar, state, dispatcher)
                    }
                }
            },
            containerColor = backgroundColor
        ) { paddingValues ->
            Column(Modifier.padding(paddingValues)) {
                component.content.forEach { RenderComponent(it, state, dispatcher) }
            }
        }
    }
}

@Composable
fun RenderComponent(component: Component, state: ScreenState, dispatcher: ActionDispatcher) {
    when (component) {
        is TextComponent -> TextRenderer.Render(component, state)
        is ButtonComponent -> ButtonRenderer.Render(component, state, dispatcher)
        is ImageComponent -> ImageRenderer.Render(component, state)
        is TextFieldComponent -> TextFieldRenderer.Render(component, state, dispatcher)
        is IconComponent -> IconRenderer.Render(component, state, dispatcher)
        is CheckboxComponent -> CheckboxRenderer.Render(component, state)
        is RowComponent -> RowRenderer.Render(component, state, dispatcher)
        is BoxComponent -> Render(component, state, dispatcher)
        is ColumnComponent -> ColumnRenderer.Render(component, state, dispatcher)
        is CardComponent -> CardRenderer.Render(component, state, dispatcher)
        is SnackbarComponent -> SnackbarRenderer.Render(component, state, dispatcher)
        is BottomSheetComponent -> BottomSheetRenderer.Render(component, state, dispatcher)
        else -> {
            println("Unknown component type: ${component::class.simpleName}")
        }
    }
}