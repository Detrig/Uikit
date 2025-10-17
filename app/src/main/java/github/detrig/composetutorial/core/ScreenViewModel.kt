package github.detrig.composetutorial.core

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import github.detrig.composetutorial.domain.model.ReloadScreenMessage
import github.detrig.composetutorial.domain.repository.ScreenRepository
import github.detrig.composetutorial.ui.theme.common.UiState
import github.detrig.uikit.components.screen.ScreenComponent
import github.detrig.uikit.components.screen.ScreenParser
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.ActionDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class ScreenViewModel(
    private val repository: ScreenRepository,
    private val dispatcher: ActionDispatcher
) : ViewModel() {

    private val _screenComponent = MutableStateFlow<ScreenComponent?>(null)
    val screenComponent: StateFlow<ScreenComponent?> = _screenComponent

    private val _screenState = MutableStateFlow<ScreenState?>(null)
    val screenState: StateFlow<ScreenState?> = _screenState

    private val _screenUiState = MutableStateFlow<UiState<ScreenComponent>>(UiState.Initial)
    val screenUiState: StateFlow<UiState<ScreenComponent>> = _screenUiState

    fun getDispatcher(): ActionDispatcher = dispatcher

    fun loadScreenById(screenId: String) {
        if (_screenComponent.value != null) return

        viewModelScope.launch {
            try {
                val json = repository.getScreenJson(screenId)
                val screen = ScreenParser.parse(json)

                Log.d("alz-04", "screenId: ${screenId}")
                _screenComponent.value = screen
                _screenState.value = ScreenState(screen)
                _screenUiState.value = UiState.Success(screen)

                observeScreenUpdates(screenId)

            } catch (e: Exception) {
                Log.e("alz-04", "Error parsing screen", e)
                _screenUiState.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }

    private fun observeScreenUpdates(screenId: String) {
        viewModelScope.launch {
            repository.observeScreen(screenId).collect { jsonString ->
                try {
                    val message = ScreenParser.json.decodeFromString<ReloadScreenMessage>(jsonString)
                    if (message.data.id == screenId) {
                        val json = repository.getScreenJson(message.data.id)
                        val screen = ScreenParser.parse(json)
                        _screenComponent.value = screen
                        _screenState.value = ScreenState(screen)
                        _screenUiState.value = UiState.Success(screen)
                    }
                } catch (e: Exception) {
                    Log.e("alz-04", "Error parsing screen update", e)
                }
            }
        }
    }

    suspend fun loadScreenJson(screenId: String): ScreenComponent? {
        return try {
            val json = repository.getScreenJson(screenId)
            ScreenParser.parse(json)
        } catch (e: Exception) {
            Log.e("alz-04", "Error loading screen JSON for $screenId", e)
            null
        }
    }
}