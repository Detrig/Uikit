package github.detrig.composetutorial.cart

import androidx.lifecycle.ViewModel
import github.detrig.composetutorial.core.Navigation
import github.detrig.composetutorial.core.NavigationHandlerFromJson
import github.detrig.composetutorial.core.ScreenViewModel
import github.detrig.composetutorial.makeorder.MakeOrderScreen
import github.detrig.uikit.core.NavigationHandler

class CartViewModel(
    private val navigation: Navigation.Mutable,
    navigationHandler: NavigationHandler
) : ScreenViewModel(navigationHandler) {

    fun mainScreen() {
        navigation.update(MakeOrderScreen)
    }

}
