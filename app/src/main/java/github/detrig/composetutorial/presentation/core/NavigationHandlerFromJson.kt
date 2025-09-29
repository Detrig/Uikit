package github.detrig.composetutorial.presentation.core

import github.detrig.composetutorial.presentation.cart.CartScreen
import github.detrig.composetutorial.presentation.makeorder.MakeOrderScreen
import github.detrig.uikit.core.NavigationHandler
import android.util.Log

//регистрирую все экраны что есть с id из Json
class NavigationHandlerFromJson(private val navigation: Navigation.Mutable) : NavigationHandler {
    override fun navigateTo(screenId: String) {
        Log.d("alz-04", "screenId: $screenId")
        val screen: Screen = when(screenId) {
            "cart" -> CartScreen
            "make_order" -> MakeOrderScreen
            else -> Screen.Empty
        }
        navigation.update(screen)
    }
}