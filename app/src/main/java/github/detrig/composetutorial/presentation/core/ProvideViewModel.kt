package github.detrig.composetutorial.presentation.core

import androidx.lifecycle.ViewModel
import github.detrig.composetutorial.presentation.cart.CartViewModel
import github.detrig.composetutorial.presentation.main.MainViewModel
import github.detrig.composetutorial.presentation.makeorder.MakeOrderViewModel

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

