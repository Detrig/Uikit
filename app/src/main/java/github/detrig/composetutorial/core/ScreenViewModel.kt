package github.detrig.composetutorial.core

import android.util.Log
import androidx.lifecycle.ViewModel
import github.detrig.uikit.components.screen.ScreenComponent
import github.detrig.uikit.components.screen.ScreenParser
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.NavigationHandler

open class ScreenViewModel(
    protected val navigationHandler: NavigationHandler
) : ViewModel() {

    lateinit var screenState: ScreenState
        private set
    lateinit var screenModel: ScreenComponent

    fun navigateToScreenById(screenId: String) {
        navigationHandler.navigateTo(screenId)
    }

    //save state
    fun loadScreen(json: String) {
        if (!::screenModel.isInitialized) {
            screenModel = ScreenParser.parse(json)
            screenState = ScreenState(screenModel)
        }
    }
}