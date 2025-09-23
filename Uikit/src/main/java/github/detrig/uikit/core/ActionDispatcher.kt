package github.detrig.uikit.core

import github.detrig.uikit.components.screen.ScreenState

class ActionDispatcher(private val state: ScreenState) {
    private val listeners = mutableMapOf<String, (Action) -> Unit>()

    fun register(actionType: String, handler: (Action) -> Unit) {
        listeners[actionType] = handler
    }

    fun dispatch(action: Action) {
        listeners[action.action]?.invoke(action)
    }

    fun registerDefaultActions(/*navController: NavController,*/) {
//        register("navigate") { action ->
//            navController.navigate(action.targetId ?: return@register)
//        }

        register("set_value") { action ->
            state.updateComponent(action.targetId, action.value)
        }

        register("increment") { action ->
            state.incrementCounter(action.targetId ?: return@register)
        }
    }
}
