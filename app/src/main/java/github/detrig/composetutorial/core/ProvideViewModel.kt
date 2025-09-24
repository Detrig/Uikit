package github.detrig.composetutorial.core

import androidx.lifecycle.ViewModel
import github.detrig.composetutorial.cart.CartViewModel
import github.detrig.composetutorial.main.MainViewModel
import github.detrig.composetutorial.makeorder.MakeOrderViewModel

interface ProvideViewModel {

    fun <T : ViewModel> viewModel(clasz: Class<T>): T

    class Base(private val core: Core) : ProvideViewModel {
        override fun <T : ViewModel> viewModel(clasz: Class<T>): T {
            return when (clasz) {
                MainViewModel::class.java -> MainViewModel(core.navigation())
                CartViewModel::class.java -> CartViewModel(core.navigation(), core.navigationHandler())
                MakeOrderViewModel::class.java -> MakeOrderViewModel(core.navigation(), core.navigationHandler())
                else -> throw IllegalStateException("unknown $clasz")
            } as T
        }

    }
}

