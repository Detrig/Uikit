package github.detrig.composetutorial.domain.handlers

import github.detrig.composetutorial.core.navigation.Navigation
import github.detrig.composetutorial.core.Screen
import github.detrig.composetutorial.presentation.cart.CartScreen
import github.detrig.composetutorial.presentation.makeorder.MakeOrderScreen
import github.detrig.uikit.core.Action
import github.detrig.uikit.core.ActionHandler

class NavigateHandler(
    private val navigation: Navigation.Mutable
) : ActionHandler<Action.Navigate> {
    override fun canHandle(action: Action): Boolean = action is Action.Navigate

    override suspend fun handle(action: Action.Navigate) {
        navigation.update(
            when (action.targetId) {
                //"1c24b76b-f646-40d4-84e1-65a613152aa9" -> CartScreen
                "76b729c3-9213-49df-91af-25259cc56162" -> CartScreen
                "3a7c12a5-6cb2-4bc3-bc0e-1549c405b413" -> MakeOrderScreen
                else -> Screen.Empty
            }
        )
    }
}