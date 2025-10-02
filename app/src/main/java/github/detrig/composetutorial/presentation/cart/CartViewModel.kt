package github.detrig.composetutorial.presentation.cart

import github.detrig.composetutorial.core.Navigation
import github.detrig.composetutorial.core.ScreenViewModel
import github.detrig.composetutorial.domain.repository.ScreenRepository
import github.detrig.composetutorial.presentation.makeorder.MakeOrderScreen
import github.detrig.uikit.core.NavigationHandler

class CartViewModel(
    private val navigation: Navigation.Mutable,
    navigationHandler: NavigationHandler,
    screenRepository: ScreenRepository
) : ScreenViewModel(screenRepository, navigationHandler) {

    fun mainScreen() {
        navigation.update(MakeOrderScreen)
    }
}
