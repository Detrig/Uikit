package github.detrig.composetutorial.makeorder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import github.detrig.composetutorial.core.ProvideViewModel
import github.detrig.composetutorial.core.Screen
import github.detrig.uikit.components.screen.ScreenParser
import github.detrig.uikit.components.screen.ScreenRenderer
import github.detrig.uikit.components.screen.ScreenState
import github.detrig.uikit.core.ActionDispatcher

object MakeOrderScreen : Screen {
    @Composable
    override fun Show() {
        val viewModel = (LocalContext.current.applicationContext as ProvideViewModel).viewModel(
            MakeOrderViewModel::class.java
        )
        val json = """
            {
            "id": "demo_screen",
            "components": [
            {
                "type": "text",
                "id": "counter_text",
                "value": "0",
                "dataKey": "counter",
                "fontSize": 24,
                "color": "#FF5722",
                "bold": true,
                "italic": false,
                "style": {
                "width": "wrap_content",
                "height": "wrap_content",
                "padding": 16,
                "margin": 8
            },
                "actions": []
            },
            {
                "type": "text",
                "id": "description_text",
                "value": "Нажмите кнопку, чтобы увеличить счётчик",
                "fontSize": 18,
                "color": "#333333",
                "bold": false,
                "italic": true,
                "style": {
                "width": "match_parent",
                "height": "wrap_content",
                "padding": 8,
                "margin": 4
            }
            },
            {
                "type": "button",
                "id": "increment_button",
                "text": "Add +1",
                "textBold": true,
                "fontSize": 16,
                "contentPadding": 12,
                "textColor": "#FFFFFF",
                "bold": true,
                "backgroundHex": "#4CAF50",
                "action": {
                "action": "increment",
                "targetId": "counter_text"
            },
                "style": {
                "width": "200",
                "height": "56",
                "padding": 8,
                "margin": 8
            }
            },
            {
                "type": "image",
                "id": "sample_image",
                "imageUrl": "https://sun9-11.userapi.com/s/v1/ig2/eKAHHnfhUPn6LYj5WMMOMb-V-mKJNgNcC8LfP3cQbPifU9J2ax9HyNitqfabI2aRQ3qNw2gYNPGeMam8gsnxrc9z.jpg?quality=95&as=32x57,48x85,72x128,108x192,160x284,240x427,360x640,480x853,540x960,640x1138,720x1280,1080x1920,1280x2276,1440x2560&from=bu&cs=1440x0",
                "contentDescription": "Sample Image",
                "contentScale": "fit",
                "actions": [],
                "style": {
                "width": "match_parent",
                "height": "match_parent",
                "padding": 8,
                "margin": 8,
                "backgroundColor": "#EEEEEE"
            }
            }
            ]
        }
        """

        val screen = remember { ScreenParser.parse(json) }
        val state = remember { ScreenState(screen) }
        val dispatcher = remember {
            ActionDispatcher(state = state,
                navigate = { screenId ->
                    viewModel.navigateToScreenById(screenId)
                }).apply {
                registerDefaultActions()
            }
        }

        ScreenRenderer.Render(screen, state, dispatcher)
    }
}