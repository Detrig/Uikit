package github.detrig.composetutorial.presentation.makeorder

import github.detrig.composetutorial.presentation.cart.CartScreen
import github.detrig.composetutorial.core.Navigation
import github.detrig.composetutorial.core.ScreenViewModel
import github.detrig.uikit.core.NavigationHandler

class MakeOrderViewModel(
    private val navigation: Navigation.Update,
    navigationHandler: NavigationHandler
) : ScreenViewModel(navigationHandler) {

    fun cartScreen() {
        navigation.update(CartScreen)
    }

}