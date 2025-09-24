package github.detrig.composetutorial.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import github.detrig.composetutorial.core.ProvideViewModel
import github.detrig.composetutorial.core.Screen
import github.detrig.uikit.components.screen.ScreenParser
import github.detrig.uikit.components.screen.ScreenRenderer
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.ActionDispatcher

object CartScreen : Screen {

    @Composable
    override fun Show() {
        val viewModel =
            (LocalContext.current.applicationContext as ProvideViewModel).viewModel(CartViewModel::class.java)
        val json = """
            {
              "id": "main_screen",
              "components": [
                {
                  "type": "text",
                  "id": "welcome_text",
                  "value": "Добро пожаловать!",
                  "fontSize": 24,
                  "color": "#333333",
                  "bold": true,
                  "style": {
                    "width": "match_parent",
                    "height": "wrap_content",
                    "padding": 16,
                    "margin": 8
                  },
                  "actions": []
                },
                {
                  "type": "button",
                  "id": "go_to_cart",
                  "text": "Перейти в корзину",
                  "fontSize": 16,
                  "textColor": "#FFFFFF",
                  "bold": true,
                  "backgroundHex": "#4CAF50",
                  "style": {
                    "width": "200",
                    "height": "56",
                    "padding": 8,
                    "margin": 8
                  },
                  "action": {
                    "action": "navigate",
                    "targetId": "make_order"
                  }
                }
              ]
            }
            """

        val screen = remember { ScreenParser.parse(json) }
        val state = remember { ScreenState(screen) }
        val dispatcher = remember {
            ActionDispatcher(state = state) { screenId ->
                viewModel.navigateToScreenById(screenId)
            }.apply {
                registerDefaultActions()
            }
        }

        ScreenRenderer.Render(screen, state, dispatcher)
    }

}