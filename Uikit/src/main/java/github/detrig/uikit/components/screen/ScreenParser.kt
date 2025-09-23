package github.detrig.uikit.components.screen

import github.detrig.uikit.components.button.ButtonComponent
import github.detrig.uikit.components.image.ImageComponent
import github.detrig.uikit.components.text.TextComponent
import github.detrig.uikit.core.Component
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object ScreenParser {
    private val json = Json {
        classDiscriminator = "type"
        ignoreUnknownKeys = true // игнорируем лишние поля
    }

    fun parse(jsonStr: String): Screen {
        val jsonObj = json.parseToJsonElement(jsonStr).jsonObject
        val componentsJson = jsonObj["components"]?.jsonArray ?: JsonArray(emptyList())
        val id = jsonObj["id"]!!.jsonPrimitive.content
        val components =  componentsJson.map { elem ->
            val type = elem.jsonObject["type"]?.jsonPrimitive?.content
            when (type) {
                "text" -> json.decodeFromJsonElement(TextComponent.serializer(), elem)
                "button" -> json.decodeFromJsonElement(ButtonComponent.serializer(), elem)
                "image" -> json.decodeFromJsonElement(ImageComponent.serializer(), elem)
                else -> throw IllegalArgumentException("Unknown component type: $type")
            }
        }
        return Screen(id, components)
    }
}