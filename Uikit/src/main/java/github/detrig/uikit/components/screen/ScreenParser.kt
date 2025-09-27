package github.detrig.uikit.components.screen

import github.detrig.uikit.components.box.BoxComponent
import github.detrig.uikit.components.button.ButtonComponent
import github.detrig.uikit.components.card.CardComponent
import github.detrig.uikit.components.checkbox.CheckboxComponent
import github.detrig.uikit.components.column.ColumnComponent
import github.detrig.uikit.components.icon.IconComponent
import github.detrig.uikit.components.image.ImageComponent
import github.detrig.uikit.components.row.RowComponent
import github.detrig.uikit.components.spacer.SpacerComponent
import github.detrig.uikit.components.text.TextComponent
import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.components.utils.ModifierModel
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object ScreenParser {
    private val json = Json {
        classDiscriminator = "type"
        ignoreUnknownKeys = true
    }

    fun parse(jsonStr: String): ScreenComponent {
        val jsonObj = json.parseToJsonElement(jsonStr).jsonObject

        fun parseComponents(array: JsonArray?): List<Component> {
            return array?.map { elem ->
                val type = elem.jsonObject["type"]?.jsonPrimitive?.content
                when (type) {
                    "text" -> json.decodeFromJsonElement(TextComponent.serializer(), elem)
                    "button" -> json.decodeFromJsonElement(ButtonComponent.serializer(), elem)
                    "image" -> json.decodeFromJsonElement(ImageComponent.serializer(), elem)
                    "box" -> json.decodeFromJsonElement(BoxComponent.serializer(), elem)
                    "row" -> json.decodeFromJsonElement(RowComponent.serializer(), elem)
                    "column" -> json.decodeFromJsonElement(ColumnComponent.serializer(), elem)
                    "card" -> json.decodeFromJsonElement(CardComponent.serializer(), elem)
                    "checkbox" -> json.decodeFromJsonElement(CheckboxComponent.serializer(), elem)
                    "spacer" -> json.decodeFromJsonElement(SpacerComponent.serializer(), elem)
                    "icon" -> json.decodeFromJsonElement(IconComponent.serializer(), elem)
                    else -> throw IllegalArgumentException("Unknown component type: $type")
                }
            } ?: emptyList()
        }

        val topBar = parseComponents(jsonObj["topBar"]?.jsonArray)
        val bottomBar = parseComponents(jsonObj["bottomBar"]?.jsonArray)
        val content = parseComponents(jsonObj["content"]?.jsonArray)

        return ScreenComponent(
            id = jsonObj["id"]?.jsonPrimitive?.content,
            name = jsonObj["name"]?.jsonPrimitive?.content ?: "UnknownScreen",
            background = jsonObj["background"]?.jsonPrimitive?.content,
            topBar = topBar,
            bottomBar = bottomBar,
            content = content,
            modifier = jsonObj["modifier"]?.let { json.decodeFromJsonElement(ModifierModel.serializer(), it) }
        )
    }
}