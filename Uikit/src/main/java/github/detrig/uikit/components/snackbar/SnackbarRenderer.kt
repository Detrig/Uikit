import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Snackbar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.components.snackbar.SnackbarComponent
import github.detrig.uikit.core.ActionDispatcher
import github.detrig.uikit.core.ActionEvent
import github.detrig.uikit.core.performActionsForEvent

object SnackbarRenderer {

    @Composable
    fun Render(
        snackbar: SnackbarComponent,
        state: ScreenState,
        dispatcher: ActionDispatcher
    ) {
        val snackbarHostState = remember { SnackbarHostState() }

        val visible by state.snackbarState(snackbar.id ?: "")!!.collectAsState(initial = false)

        if (visible) {
            LaunchedEffect(snackbar.id) {
                snackbarHostState.showSnackbar(
                    message = snackbar.text,
                    duration = androidx.compose.material3.SnackbarDuration.Short
                )
                state.hideSnackbar(snackbar.id ?: "")
            }
        }

    }
//    Box(
//        modifier = Modifier.fillMaxWidth(),
//        contentAlignment = Alignment.BottomCenter
//    ) {
//        SnackbarHost(
//            hostState = snackbarHostState,
//            snackbar = { SnackbarData ->
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp)
//                        .background(Color(0xFF141414), RoundedCornerShape(32.dp))
//                        .padding(horizontal = 16.dp, vertical = 12.dp)
//                ) {
//                    Text(
//                        text = message,
//                        color = Color.White,
//                        modifier = Modifier.weight(1f)
//                    )
//
//                    snackbars.find { it.text == data.message }?.actionText?.let { actionText ->
//                        TextButton(
//                            onClick = {
//                                // Выполняем действие snackbar
//                                val sb = snackbars.find { it.text == data.message }
//                                sb?.performActionsForEvent(ActionEvent.OnClick, dispatcher)
//                                state.hideSnackbar(sb?.id ?: "")
//                            }
//                        ) {
//                            Text(actionText, color = Color.Black)
//                        }
//                    }
//                }
//            }
//        )
//    }
}
