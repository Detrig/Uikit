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
import github.detrig.uikit.components.snackbar.SnackbarComponent
import github.detrig.uikit.components.snackbar.SnackbarData
import github.detrig.uikit.components.utils.Component
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ScreenState(screen: ScreenComponent) {

    private val componentStates = mutableStateMapOf<String, Any?>()

    private val visibleSnackbars = mutableStateMapOf<String, Boolean>()

    init {
        screen.snackbars.forEach { snackbar ->
            Log.d("alz-04", "snackbar: $snackbar")
            val id = snackbar.id ?: return@forEach

            visibleSnackbars[id] = false
        }

        fun traverse(component: Component) {
            val id = component.id ?: return
            Log.d("alz-04", "component: $component")
            when (component) {
                is TextComponent -> componentStates[id] = component.text
                is CheckboxComponent -> componentStates[id] = component.isChecked
                is ButtonComponent -> componentStates[id] = component.enabled
                is LazyColumnComponent -> componentStates[id] = emptyList<Any>()
            }

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



    fun showSnackbar(id: String) {
        Log.d("alz-04", "showSnackbar: $id, $visibleSnackbars")
        visibleSnackbars[id] = true
        // auto hide через корутину
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            visibleSnackbars[id] = false
        }
    }
    fun isSnackbarVisible(id: String): Boolean = visibleSnackbars[id] == true
    fun hideSnackbar(id: String) {
        visibleSnackbars[id] = false
    }

}