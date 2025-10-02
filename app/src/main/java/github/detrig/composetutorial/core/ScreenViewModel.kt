package github.detrig.composetutorial.core

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.detrig.composetutorial.domain.repository.ScreenRepository
import github.detrig.uikit.components.screen.ScreenComponent
import github.detrig.uikit.components.screen.ScreenParser
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.NavigationHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class ScreenViewModel(
    private val repository: ScreenRepository,
    protected val navigationHandler: NavigationHandler
) : ViewModel() {

    private val _screenComponent = MutableStateFlow<ScreenComponent?>(null)
    val screenComponent: StateFlow<ScreenComponent?> = _screenComponent

    private val _screenState = MutableStateFlow<ScreenState?>(null)
    val screenState: StateFlow<ScreenState?> = _screenState

    fun loadScreenById(screenId: String) {
        if (_screenComponent.value != null) return
        viewModelScope.launch {
            try {
                val json = repository.getScreenJson(screenId)

                val screen = ScreenParser.parse(json)
                _screenComponent.value = screen
                _screenState.value = ScreenState(screen)

            } catch (e: Exception) {
                Log.e("alz-04", "Error parsing screen", e)
            }
        }
    }


    fun navigateToScreenById(screenId: String) {
        navigationHandler.navigateTo(screenId)
    }
}