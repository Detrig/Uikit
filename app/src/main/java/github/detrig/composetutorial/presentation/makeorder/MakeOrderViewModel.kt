package github.detrig.composetutorial.presentation.makeorder

import github.detrig.composetutorial.presentation.cart.CartScreen
import github.detrig.composetutorial.presentation.core.Navigation
import github.detrig.composetutorial.presentation.core.ScreenViewModel
import github.detrig.uikit.core.NavigationHandler

class MakeOrderViewModel(
    private val navigation: Navigation.Update,
    navigationHandler: NavigationHandler
) : ScreenViewModel(navigationHandler) {

    fun cartScreen() {
        navigation.update(CartScreen)
    }

}