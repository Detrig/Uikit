package github.detrig.composetutorial.main

import androidx.lifecycle.ViewModel
import github.detrig.composetutorial.cart.CartScreen
import github.detrig.composetutorial.core.Navigation
import github.detrig.composetutorial.core.Screen
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(
    private val navigation: Navigation.Mutable
) : ViewModel(), Navigation.Read {

    fun init(firstRun: Boolean) {
        if (firstRun)
            navigation.update(CartScreen)
    }

    override fun screen(): StateFlow<Screen> {
        return navigation.screen()
    }
}