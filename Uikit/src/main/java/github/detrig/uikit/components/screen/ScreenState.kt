package github.detrig.uikit.components.screen

import androidx.compose.runtime.mutableStateMapOf
import github.detrig.uikit.components.button.ButtonComponent
import github.detrig.uikit.components.text.TextComponent
import android.util.Log
import github.detrig.uikit.components.box.BoxComponent
import github.detrig.uikit.components.card.CardComponent
import github.detrig.uikit.components.checkbox.CheckboxComponent
import github.detrig.uikit.components.column.ColumnComponent
import github.detrig.uikit.components.lazycolumn.LazyColumnComponent
import github.detrig.uikit.components.row.RowComponent
import github.detrig.uikit.components.utils.Component

class ScreenState(screen: ScreenComponent) {

    private val componentStates = mutableStateMapOf<String, Any?>()

    init {
        fun traverse(component: Component) {
            val id = component.id ?: return
            when (component) {
                is TextComponent -> componentStates[id] = component.text
                is CheckboxComponent -> componentStates[id] = component.isChecked
                is ButtonComponent -> componentStates[id] = component.enabled
                is LazyColumnComponent -> componentStates[id] = emptyList<Any>()
            }

            // Рекурсивно обходим детей
            when (component) {
                is RowComponent -> component.children.forEach { traverse(it) }
                is ColumnComponent -> component.children.forEach { traverse(it) }
                is BoxComponent -> component.children.forEach { traverse(it) }
                is CardComponent -> component.children.forEach { traverse(it) }
            }
        }

        screen.topBar.forEach { traverse(it) }
        screen.content.forEach { traverse(it) }
        screen.bottomBar.forEach { traverse(it) }
    }

    fun updateComponent(id: String?, value: Any?) {
        if (id != null) componentStates[id] = value
    }

    fun getValue(id: String?): Any? = id?.let { componentStates[it] }

    fun getList(id: String?): List<Any>? = id?.let { componentStates[it] as? List<Any> }
}