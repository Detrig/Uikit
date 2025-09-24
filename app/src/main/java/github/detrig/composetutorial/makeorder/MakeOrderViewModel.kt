package github.detrig.composetutorial.makeorder

import androidx.lifecycle.ViewModel
import github.detrig.composetutorial.cart.CartScreen
import github.detrig.composetutorial.core.Navigation
import github.detrig.composetutorial.core.ScreenViewModel
import github.detrig.uikit.components.screen.ScreenModel
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.ActionDispatcher
import github.detrig.uikit.core.NavigationHandler

class MakeOrderViewModel(
    private val navigation: Navigation.Update,
    navigationHandler: NavigationHandler
) : ScreenViewModel(navigationHandler) {

    fun cartScreen() {
        navigation.update(CartScreen)
    }

}