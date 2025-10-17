package github.detrig.uikit.components.screen

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateMapOf
import github.detrig.uikit.components.button.ButtonComponent
import github.detrig.uikit.components.text.TextComponent
import github.detrig.uikit.components.bottomsheet.BottomSheetComponent
import github.detrig.uikit.components.box.BoxComponent
import github.detrig.uikit.components.card.CardComponent
import github.detrig.uikit.components.checkbox.CheckboxComponent
import github.detrig.uikit.components.column.ColumnComponent
import github.detrig.uikit.components.row.RowComponent
import github.detrig.uikit.components.textfield.TextFieldComponent
import github.detrig.uikit.components.utils.Component
import github.detrig.uikit.custom_components.ListComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ScreenState(screen: ScreenComponent) {

    private val componentStates = mutableStateMapOf<String, MutableState<Any?>>()

    private val visibleSheets = mutableStateMapOf<String, Boolean>()

    init {

        fun traverse(component: Component) {
            val id = component.id ?: return
            when (component) {
                is TextComponent -> componentStates[id] = mutableStateOf(component.text)
                is CheckboxComponent -> componentStates[id] = mutableStateOf(component.isChecked)
                is ButtonComponent -> componentStates[id] = mutableStateOf(component.enabled)
                is TextFieldComponent -> componentStates[id] = mutableStateOf(component.value ?: "")
            }

            when (component) {
                is RowComponent -> component.children.forEach { traverse(it) }
                is ColumnComponent -> component.children.forEach { traverse(it) }
                is BoxComponent -> component.children.forEach { traverse(it) }
                is CardComponent -> component.children.forEach { traverse(it) }
                is BottomSheetComponent -> component.children.forEach {
                    traverse(it)
                    Log.d("alz-04", "BottomSheetComponent: $it")
                }

                is ListComponent -> component.items.forEach { traverse(it) }
            }
        }

        screen.topBar.forEach { traverse(it) }
        screen.content.forEach { traverse(it) }
        screen.bottomBar.forEach { traverse(it) }
        screen.bottomSheets.forEach { sheet ->
            val id = sheet.id ?: return@forEach
            visibleSheets[id] = false
            traverse(sheet)
        }
    }

    fun getValueState(id: String): MutableState<Any?>? = componentStates[id]

    fun updateComponent(id: String, value: Any?) {
        componentStates[id]?.value = value
    }

    fun getList(id: String?): List<Any>? = id?.let { componentStates[it] as? List<Any> }

    private val snackbars: Map<String, MutableStateFlow<Boolean>> =
        screen.snackbars.associate { it.id!! to MutableStateFlow(false) }

    fun showSnackbar(id: String) {
        snackbars[id]?.value = true
        Log.d("alz-04", "snackbars: $id")
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            snackbars[id]?.value = false
        }
    }

    fun hideSnackbar(id: String) {
        Log.d("alz-04", "hideSnackbar: $id")
        snackbars[id]?.value = false
    }

    fun snackbarState(id: String): StateFlow<Boolean>? = snackbars[id]


    //Sheet
    fun showSheet(id: String) {
        visibleSheets[id] = true
    }

    fun hideSheet(id: String) {
        visibleSheets[id] = false
    }

    @Composable
    fun sheetVisibleState(id: String): State<Boolean> {
        val state = remember { derivedStateOf { visibleSheets[id] == true } }
        Log.d("alz-04", "sheetVisibleState($id) = ${state.value}")
        return state
    }

}