package github.detrig.composetutorial.presentation.cart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import github.detrig.composetutorial.core.Screen
import github.detrig.composetutorial.di.ProvideViewModel
import github.detrig.uikit.components.screen.ScreenRenderer
import github.detrig.composetutorial.ui.theme.common.UiStateHandler
import github.detrig.uikit.components.screen.ScreenState

object CartScreen : Screen {
    private const val SCREEN_ID = "1c24b76b-f646-40d4-84e1-65a613152aa9"
    //private const val SCREEN_ID = "76b729c3-9213-49df-91af-25259cc56162"
    //private const val SCREEN_ID = "4761c8a0-74bf-4733-8444-93faebb6f6da"
    //private const val SCREEN_ID = "4761c8a0-74bf-4733-8444-93faebb6f6da"
    //private const val SCREEN_ID = "21d7850d-1775-4610-9ccd-5896515aa381"
    //private const val SCREEN_ID = "9abfbcab-f242-4a1d-a3d4-0f4d9a84cd33"

    @Composable
    override fun Show() {
        val viewModel =
            (LocalContext.current.applicationContext as ProvideViewModel)
                .viewModel(CartViewModel::class.java)

        LaunchedEffect(Unit) {
            viewModel.loadScreenById(SCREEN_ID)
        }

        val screenUiState by viewModel.screenUiState.collectAsState()

        UiStateHandler.ScreenStateHandler(
            uiState = screenUiState,
            fetchScreenJson = { screenId -> viewModel.loadScreenJson(screenId) },
            onRetry = { } //viewModel.loadScreenFromJsonString(json) }
        ) { screenComponent ->
            ScreenRenderer.Render(screenComponent, ScreenState(screenComponent), viewModel.getDispatcher())
        }
    }


}