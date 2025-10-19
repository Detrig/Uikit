package github.detrig.uikit.core

import github.detrig.uikit.components.bottomsheet.BottomSheetComponent
import github.detrig.uikit.components.box.BoxComponent
import github.detrig.uikit.components.card.CardComponent
import github.detrig.uikit.components.column.ColumnComponent
import github.detrig.uikit.components.image.ImageComponent
import github.detrig.uikit.components.row.RowComponent
import github.detrig.uikit.components.screen.ScreenComponent
import github.detrig.uikit.components.screen.ScreenParser
import github.detrig.uikit.components.text.TextComponent
import github.detrig.uikit.components.textfield.TextFieldComponent
import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.universal_lazy_list.ListComponent
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object DataBinder {

    /**
     * Подставляет данные из data в компонент, рекурсивно обходя всех детей
     */
    fun bindData(component: Component, data: JsonObject): Component {
        val jsonElement = ScreenParser.json.encodeToJsonElement(Component.serializer(), component).jsonObject
        val substituted = substituteInJson(jsonElement, data)
        return ScreenParser.json.decodeFromJsonElement(Component.serializer(), substituted)
    }

    private fun substituteInJson(element: JsonElement, data: JsonObject): JsonElement {
        return when (element) {
            is JsonObject -> JsonObject(
                element.mapValues { (_, v) -> substituteInJson(v, data) }
            )
            is JsonArray -> JsonArray(element.map { substituteInJson(it, data) })
            is JsonPrimitive -> {
                if (element.isString && element.content.startsWith("$")) {
                    val key = element.content.removePrefix("$")
                    data[key] ?: JsonPrimitive("")
                } else element
            }
            else -> element
        }
    }
}