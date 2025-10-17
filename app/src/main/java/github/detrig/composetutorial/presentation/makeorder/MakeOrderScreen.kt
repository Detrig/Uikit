package github.detrig.composetutorial.presentation.makeorder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import github.detrig.composetutorial.core.Screen
import github.detrig.composetutorial.di.ProvideViewModel
import github.detrig.composetutorial.presentation.cart.CartScreen
import github.detrig.composetutorial.ui.theme.common.UiStateHandler
import github.detrig.uikit.components.screen.ScreenRenderer
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.ActionDispatcher


object MakeOrderScreen : Screen {
    //private const val SCREEN_ID = "76b729c3-9213-49df-91af-25259cc56162"
    private const val SCREEN_ID = "3a7c12a5-6cb2-4bc3-bc0e-1549c405b413"

    @Composable
    override fun Show() {
        val viewModel = (LocalContext.current.applicationContext as ProvideViewModel).viewModel(
            MakeOrderViewModel::class.java
        )

        LaunchedEffect(Unit) {
            viewModel.loadScreenById(MakeOrderScreen.SCREEN_ID)
        }

        val screenUiState by viewModel.screenUiState.collectAsState()

        UiStateHandler.ScreenStateHandler(
            uiState = screenUiState,
            fetchScreenJson = { screenId -> viewModel.loadScreenJson(screenId) },
            onRetry = { } // { viewModel.loadScreenById(SCREEN_ID) }
        ) { screenComponent ->
            ScreenRenderer.Render(screenComponent, ScreenState(screenComponent), viewModel.getDispatcher())
        }
    }
}