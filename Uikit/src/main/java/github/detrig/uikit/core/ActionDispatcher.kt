package github.detrig.uikit.core

import android.util.Log
import github.detrig.uikit.components.screen.ScreenState
import kotlin.math.max

class ActionDispatcher(
    private val state: ScreenState,
    private val navigate: ((String) -> Unit)? = null
) {
    private val listeners = mutableMapOf<String, (Action) -> Unit>()

    fun register(actionType: String, handler: (Action) -> Unit) {
        listeners[actionType] = handler
    }

    fun dispatch(action: Action) {
        Log.d("alz-04", "action: $action")
        listeners[action.action]?.invoke(action)
    }

    fun registerDefaultActions(/*navController: NavController,*/) {
//        register("navigate") { action ->
//            navController.navigate(action.targetId ?: return@register)
//        }

        register("set_value") { action ->
            state.updateComponent(action.targetId, action.value)
        }

        register("navigate") { action ->
            action.targetId?.let { navigate?.invoke(it) }
        }

        register("increment") { action ->
            state.incrementCounter(action.targetId ?: return@register)
        }

        register("decrement") { action ->
            val current = (state.getValue(action.targetId ?: "") as? Int ?: 0)
            state.updateComponent(action.targetId, max(0, current - 1))
        }

//        register("delete") { action ->
//            state.removeComponent(action.targetId ?: return@register)
//        }
    }
}
