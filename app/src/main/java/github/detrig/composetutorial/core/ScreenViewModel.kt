package github.detrig.composetutorial.core

import androidx.lifecycle.ViewModel
import github.detrig.uikit.core.NavigationHandler

open class ScreenViewModel(
    protected val navigationHandler: NavigationHandler
) : ViewModel() {

    fun navigateToScreenById(screenId: String) {
        navigationHandler.navigateTo(screenId)
    }
}