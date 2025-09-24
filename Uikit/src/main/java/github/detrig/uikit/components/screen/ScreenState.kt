package github.detrig.uikit.components.screen

import androidx.compose.runtime.mutableStateMapOf
import github.detrig.uikit.components.button.ButtonComponent
import github.detrig.uikit.components.text.TextComponent

class ScreenState(val screenModel: ScreenModel) {
    private val componentStates = mutableStateMapOf<String, Any?>()

    init {
        screenModel.components.forEach { component ->
            when (component) {
                is TextComponent -> componentStates[component.id ?: ""] = component.value
                is ButtonComponent -> {}
            }
        }
    }

    fun updateComponent(id: String?, value: Any?) {
        if (id != null) {
            componentStates[id] = value
        }
    }

    fun incrementCounter(id: String) {
        val current = (componentStates[id] as? Int ?: 0)
        componentStates[id] = current + 1
    }

    fun getValue(id: String): Any? = componentStates[id]
}