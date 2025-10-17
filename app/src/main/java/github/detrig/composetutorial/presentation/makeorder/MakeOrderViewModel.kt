package github.detrig.composetutorial.presentation.makeorder

import github.detrig.composetutorial.presentation.cart.CartScreen
import github.detrig.composetutorial.core.navigation.Navigation
import github.detrig.composetutorial.core.ScreenViewModel
import github.detrig.composetutorial.domain.repository.ScreenRepository
import github.detrig.uikit.core.ActionDispatcher

class MakeOrderViewModel(
    private val navigation: Navigation.Mutable,
    private val dispatcher: ActionDispatcher,
    screenRepository: ScreenRepository
) : ScreenViewModel(navigation, screenRepository, dispatcher) {

    fun cartScreen() {
        navigation.update(CartScreen)
    }

}