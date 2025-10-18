package github.detrig.composetutorial.presentation.cart

import android.util.Log
import androidx.lifecycle.viewModelScope
import github.detrig.composetutorial.core.navigation.Navigation
import github.detrig.composetutorial.core.ScreenViewModel
import github.detrig.composetutorial.domain.repository.ScreenRepository
import github.detrig.composetutorial.ui.theme.common.UiState
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.ActionDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel(
    navigation: Navigation.Mutable,
    repository: ScreenRepository,
    val dispatcher: ActionDispatcher
) : ScreenViewModel(navigation, repository, dispatcher) {

    private val _cartScreenState = MutableStateFlow<ScreenState?>(null)
    val cartScreenState: StateFlow<ScreenState?> = _cartScreenState

    fun loadScreen(screenId: String) {
        viewModelScope.launch {
            val screen = loadScreenJson(screenId) ?: return@launch

            val isFirstLoad = _cartScreenState.value == null
            Log.d("alz-debug", "loadScreen called for $screenId, isFirstLoad=$isFirstLoad")

            if (isFirstLoad) {
                val state = ScreenState(screen)
                _cartScreenState.value = state
                registerHandlers(state)
                observeScreenUpdates(screenId)
            } else {
                _cartScreenState.value?.updateFrom(screen)
            }

            _screenComponent.value = screen
            _screenUiState.value = UiState.Success(screen)
        }
    }
}