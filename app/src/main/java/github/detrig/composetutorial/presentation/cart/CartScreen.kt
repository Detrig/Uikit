package github.detrig.composetutorial.presentation.cart

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import github.detrig.composetutorial.core.Screen
import github.detrig.composetutorial.di.ProvideViewModel
import github.detrig.uikit.components.screen.ScreenRenderer
import github.detrig.uikit.core.ActionDispatcher
import android.util.Log

object CartScreen : Screen {
    const val SCREEN_ID = "c01d04b9-cd45-4eda-85ad-d6d5b979c870"

    @Composable
    override fun Show() {
        val viewModel =
            (LocalContext.current.applicationContext as ProvideViewModel).viewModel(CartViewModel::class.java)


        LaunchedEffect(Unit) {
            viewModel.loadScreenById(SCREEN_ID)
        }

        val screenModel by viewModel.screenComponent.collectAsState()
        val screenState by viewModel.screenState.collectAsState()

        screenModel?.let { model ->
            screenState?.let { state ->
                val dispatcher = remember(state) {   // пересоздаётся при изменении screenState
                    ActionDispatcher(state = state) { screenId ->
                        viewModel.navigateToScreenById(screenId)
                    }.apply { registerDefaultActions() }
                }

                Log.d("alz-04", "screenModel: $screenModel")
                ScreenRenderer.Render(
                    model,
                    state,
                    dispatcher
                )
            }
        } ?: CircularProgressIndicator(modifier = Modifier.size(24.dp))

    }

}
