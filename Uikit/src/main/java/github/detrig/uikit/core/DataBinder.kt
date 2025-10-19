package github.detrig.uikit.core

import github.detrig.uikit.components.bottomsheet.BottomSheetComponent
import github.detrig.uikit.components.box.BoxComponent
import github.detrig.uikit.components.card.CardComponent
import github.detrig.uikit.components.column.ColumnComponent
import github.detrig.uikit.components.image.ImageComponent
import github.detrig.uikit.components.row.RowComponent
import github.detrig.uikit.components.screen.ScreenComponent
import github.detrig.uikit.components.text.TextComponent
import github.detrig.uikit.components.textfield.TextFieldComponent
import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.universal_lazy_list.ListComponent
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonPrimitive

object DataBinder {

    fun bindDataToScreen(screen: ScreenComponent, data: JsonObject) {
        screen.content.forEach { bindDataToComponent(it, data) }
        screen.topBar.forEach { bindDataToComponent(it, data) }
        screen.bottomBar.forEach { bindDataToComponent(it, data) }
    }

    private fun bindDataToComponent(component: Component, data: JsonObject) {
        when (component) {
            is TextComponent -> {
                component.text = resolvePlaceholders(component.text ?: "", data)
            }
            is ImageComponent -> {
                component.url = resolvePlaceholders(component.url ?: "", data)
            }
            is TextFieldComponent -> {
                component.value = resolvePlaceholders(component.value ?: "", data)
            }
        }

        when (component) {
            is RowComponent -> component.children.forEach { bindDataToComponent(it, data) }
            is ColumnComponent -> component.children.forEach { bindDataToComponent(it, data) }
            is CardComponent -> component.children.forEach { bindDataToComponent(it, data) }
            is BoxComponent -> component.children.forEach { bindDataToComponent(it, data) }
            is ListComponent -> component.items.forEach { bindDataToComponent(it, data) }
            is BottomSheetComponent -> component.children.forEach { bindDataToComponent(it, data) }
        }
    }

    private fun resolvePlaceholders(template: String, data: JsonObject): String {
        var result = template
        val regex = "\\$([a-zA-Z0-9_]+)".toRegex()
        regex.findAll(template).forEach { match ->
            val key = match.groupValues[1]
            val value = data[key]?.jsonPrimitive?.contentOrNull ?: ""
            result = result.replace("\$$key", value)
        }
        return result
    }
}