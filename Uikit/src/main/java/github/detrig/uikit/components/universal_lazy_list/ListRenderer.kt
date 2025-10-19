package github.detrig.uikit.components.universal_lazy_list

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import github.detrig.uikit.components.screen.ScreenParser
import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.states.ScreenState
import github.detrig.uikit.components.utils.ComponentRenderer
import github.detrig.uikit.components.utils.toComposeModifier
import github.detrig.uikit.core.ActionDispatcher
import github.detrig.uikit.states.DataState
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

object ListRenderer {
    @Composable
    fun Render(
        component: ListComponent,
        state: ScreenState,
        dataState: DataState,
        dispatcher: ActionDispatcher
    ) {
        val items = dataState.getList(component.id ?: "") ?: emptyList()

        LazyColumn(
            modifier = component.modifier?.toComposeModifier() ?: Modifier.fillMaxWidth()
        ) {
            items(items.size) { index ->
                val itemData = items[index]
                Log.d("alz-04", "itemData $itemData")
                val filledTemplate = substituteDataFromJson(component.template, itemData)

                ComponentRenderer.Render(filledTemplate, state, dataState, dispatcher)
            }
        }
    }

    fun substituteDataFromJson(template: JsonObject, data: JsonObject): Component {
        val substituted = substituteInJson(template, data)
        return ScreenParser.json.decodeFromJsonElement(Component.serializer(), substituted)
    }

    /**
     * Рекурсивная подстановка значений из data в шаблон
     */
    private fun substituteInJson(element: JsonElement, data: JsonObject): JsonElement {
        return when (element) {
            is JsonObject -> JsonObject(
                element.mapValues { (_, v) -> substituteInJson(v, data) }
            )

            is JsonArray -> JsonArray(element.map { substituteInJson(it, data) })
            is JsonPrimitive -> {
                if (element.isString && element.content.startsWith("$")) {
                    val key = element.content.removePrefix("$")
                    data[key] ?: JsonPrimitive("") // если нет значения — пустая строка
                } else {
                    element
                }
            }

            else -> element
        }
    }
}